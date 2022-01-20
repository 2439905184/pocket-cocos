window.__require = function e(t, n, r) {
  function s(o, u) {
    if (!n[o]) {
      if (!t[o]) {
        var b = o.split("/");
        b = b[b.length - 1];
        if (!t[b]) {
          var a = "function" == typeof __require && __require;
          if (!u && a) return a(b, !0);
          if (i) return i(b, !0);
          throw new Error("Cannot find module '" + o + "'");
        }
        o = b;
      }
      var f = n[o] = {
        exports: {}
      };
      t[o][0].call(f.exports, function(e) {
        var n = t[o][1][e];
        return s(n || e);
      }, f, f.exports, e, t, n, r);
    }
    return n[o].exports;
  }
  var i = "function" == typeof __require && __require;
  for (var o = 0; o < r.length; o++) s(r[o]);
  return s;
}({
  call_android: [ function(require, module, exports) {
    "use strict";
    cc._RF.push(module, "6fc9d7+XtJJl7PW3LIGnsH2", "call_android");
    "use strict";
    cc.Class({
      extends: cc.Component,
      properties: {},
      start: function start() {},
      test: function test() {
        jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "hello", "()V");
      },
      showInter: function showInter() {
        jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "showAD", "(Ljava/lang/String;Ljava/lang/String;)V", "inter", "6");
      },
      showReward: function showReward() {
        jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "showAD", "(Ljava/lang/String;Ljava/lang/String;)V", "reward", "2");
      }
    });
    cc._RF.pop();
  }, {} ]
}, {}, [ "call_android" ]);