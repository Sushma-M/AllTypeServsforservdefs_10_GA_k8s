var $sce = App.getDependency("$sce");
/*global Application */

/* Define the property change handler. This function will be triggered when there is a change in the prefab property */

function propertyChangeHandler(key, newVal) {
    switch (key) {
    case "youtubeurl":
        if (!newVal) {
            return;
        }
        newVal = CONSTANTS.hasCordova ? newVal : Utils.removeProtocol(newVal);
        newVal = newVal.replace("/watch?v=", "/embed/");
        newVal += (newVal.indexOf("?") === -1 ? "?" : "&") + "wmode=transparent";
        Prefab.url = $sce.trustAsResourceUrl(newVal);
        break;
    case "allowfullscreen":
        var iframeEl = $('[data-youtube-frame-id="' + Prefab.$id + '"]');
        if (!iframeEl.length) {
            iframeEl = $("[data-ng-controller='YoutubeController']>iframe");
        }
        newVal ? iframeEl.attr(key, key) : iframeEl.removeAttr(key);
        break;
    }
}
/* register the property change handler */

Prefab.onPropertyChange = propertyChangeHandler;
/* this will be triggered after the prefab is initialized */

Prefab.onReady = function () {
    // do nothing
};

