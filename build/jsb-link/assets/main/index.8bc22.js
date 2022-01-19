window.__require = function t(r, n, o) {
function e(c, a) {
if (!n[c]) {
if (!r[c]) {
var l = c.split("/");
l = l[l.length - 1];
if (!r[l]) {
var s = "function" == typeof __require && __require;
if (!a && s) return s(l, !0);
if (i) return i(l, !0);
throw new Error("Cannot find module '" + c + "'");
}
c = l;
}
var u = n[c] = {
exports: {}
};
r[c][0].call(u.exports, function(t) {
return e(r[c][1][t] || t);
}, u, u.exports, t, r, n, o);
}
return n[c].exports;
}
for (var i = "function" == typeof __require && __require, c = 0; c < o.length; c++) e(o[c]);
return e;
}({
call_android: [ function(t, r) {
"use strict";
cc._RF.push(r, "6fc9d7+XtJJl7PW3LIGnsH2", "call_android");
cc.Class({
extends: cc.Component,
properties: {},
start: function() {},
ad_types: [ "banner", "reward", "inter" ],
test: function() {
jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "hello", "()V");
},
showInter: function() {
jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "showAD", "(Ljava/lang/String;Ljava/lang/String;)V", "banner", "unknow id");
},
showReward: function() {
jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "showAD", "(Ljava/lang/String;Ljava/lang/String;)V", "reward", "unknow id");
}
});
cc._RF.pop();
}, {} ]
}, {}, [ "call_android" ]);