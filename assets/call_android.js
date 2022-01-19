// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        // foo: {
        //     // ATTRIBUTES:
        //     default: null,        // The default value will be used only when the component attaching
        //                           // to a node for the first time
        //     type: cc.SpriteFrame, // optional, default is typeof default
        //     serializable: true,   // optional, default is true
        // },
        // bar: {
        //     get () {
        //         return this._bar;
        //     },
        //     set (value) {
        //         this._bar = value;
        //     }
        // },
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () 
    {

    },
    test : function()
    {
      cc.log("hello world")
      //正式接入时请更换这里的参数包名
      //jsb.reflection.callStaticMethod("com/xiaofengyu/travel")
      //调用Toast输出hello world测试
      jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity","hello","()V")
    },
    init : function()
    {
     // jsb.reflection.callStaticMethod("com/cocos/game/Test", "hello", "(Ljava/lang/String;)V", "this is a message from JavaScript");
    },
    // update (dt) {},
});
