var exec = cordova.require(`cordova/exec`);

var cookiesSync = {
    sync: function () {
        exec(undefined, undefined, `CookiesSync`, `sync`, []);
    }
};

module.exports = cookiesSync;
