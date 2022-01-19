window.__require = function r(t, n, e) {
function o(c, l) {
if (!n[c]) {
if (!t[c]) {
var u = c.split("/");
u = u[u.length - 1];
if (!t[u]) {
var f = "function" == typeof __require && __require;
if (!l && f) return f(u, !0);
if (i) return i(u, !0);
throw new Error("Cannot find module '" + c + "'");
}
c = u;
}
var a = n[c] = {
exports: {}
};
t[c][0].call(a.exports, function(r) {
return o(t[c][1][r] || r);
}, a, a.exports, r, t, n, e);
}
return n[c].exports;
}
for (var i = "function" == typeof __require && __require, c = 0; c < e.length; c++) o(e[c]);
return o;
}({
call_android: [ function(r, t) {
"use strict";
cc._RF.push(t, "6fc9d7+XtJJl7PW3LIGnsH2", "call_android");
cc.Class({
extends: cc.Component,
properties: {},
start: function() {},
test: function() {
cc.log("hello world");
jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "hello", "()V");
},
init: function() {}
});
cc._RF.pop();
}, {} ]
}, {}, [ "call_android" ]);