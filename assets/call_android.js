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

    start() {

    },
    //横幅 激励视频 插屏静态广告
    //ad_types:["banner","reward","inter"],
    //调用Toast输出hello world测试
    test: function() {
        //cc.log("hello world")
        jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "hello", "()V")
    },
    //测试插屏广告 请输入正式id进行测试
    showInter: function() {
        jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "showAD", "(Ljava/lang/String;Ljava/lang/String;)V","inter","unknow id")
    },
    //测试激励广告 请输入正式id进行测试
    showReward:function()
    {
        jsb.reflection.callStaticMethod("org/cocos2dx/javascript/AppActivity", "showAD","(Ljava/lang/String;Ljava/lang/String;)V","reward","unknow id")
    }
    // update (dt) {},
});