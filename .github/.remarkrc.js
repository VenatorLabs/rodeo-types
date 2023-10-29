const baseConfig = require("../.remarkrc");

module.exports = {
    ...baseConfig,
    plugins:
        process.env.CI || false
            ? [] // remove plugins to ensure non-production files do not fail CI
            : [
                  ...baseConfig.plugins,
                  ["remark-lint-no-file-name-irregular-characters", false],
                  ["remark-lint-no-file-name-mixed-case", false]
              ]
};
