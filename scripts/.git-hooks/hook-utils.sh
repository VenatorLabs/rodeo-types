#!/bin/sh
# Shell utility functions for git-hooks
# --------------------------------------
[ -z "$LOG_PREFIX" ] && LOG_PREFIX="[scripts/.git-hooks/???]"

# as opposed to echo, interpret C escape sequences properly in all envs
replay() {
    printf '%s\n' "$*"
}

# Print to stdout as messages with a prefix of $LOG_PREFIX
log() {
    replay "$@" | awk -v "PREFIX=$LOG_PREFIX" -F '\\\\n' '{print PREFIX " " $1}'
}

# Print to stderr as messages with a prefix of $LOG_PREFIX
error() {
    replay "$@" | awk >&2 -v "PREFIX=$LOG_PREFIX" -F '\\\\n' '{print PREFIX " " $1}'
}

# Prints and runs command
explicit_run_cmd() {
    cmd="$1"
    log "$> $cmd"
    eval "$cmd"
}

# Function to configure git repository to include project `.gitconfig`
config_git_project_gitconfig() {
    current_includepath="$(git config --local --get include.path || true)"
    project_gitconfig_file="../.gitconfig"
    if [ -f ".git" ]; then # check if repo is a submodule (ie. .git is a file instead of directory)
        if ! output="$(git config --get core.worktree)"; then
            error "ERROR: unable to determine the submodule location path."
            error "ERROR: failed to add project .gitconfig to local git configuration."
            return 1
        fi
        # prepend worktree to the project gitconfig path => large relative path from top level .git/modules/*
        project_gitconfig_file="${output}/${project_gitconfig_file##*/}"
        unset -v output
    fi
    if [ "$current_includepath" = "$project_gitconfig_file" ]; then
        unset -v current_includepath project_gitconfig_file
        return 0 # As desired, return silently
    fi
    unset -v current_includepath
    if [ -f "$(basename "$project_gitconfig_file")" ]; then
        if ! git config --local include.path "$project_gitconfig_file"; then
            error "ERROR: failed to add project .gitconfig to local git configuration."
            unset -v project_gitconfig_file
            return 1
        fi
        log "SUCCESS: Project .gitconfig added to repository configuration."
    fi
    unset -v project_gitconfig_file
}

# Unset all functions/vars this utils file creates
cleanup() {
    unset -v LOG_PREFIX
    unset -f cleanup replay log error explicit_run_cmd config_git_project_gitconfig
}
