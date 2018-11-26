// pages/my/my.js
const app = getApp();


Page({
    data: {
        info: {},
        joinTime: ""
    },
    onShow: function () {
        let user = app.user.get();
        this.setData({
            info: user,
            joinTime: app.util.idate(user.uid)
        });
    },
    todo: function () {
        dd.navigateTo({
            url: '/pages/my/todo/index'
        })
    },
    create: function () {
        dd.navigateTo({
            url: '/pages/my/create/index'
        })
    },
    quit: function () {
        app.user.clean();
        dd.alert({content: "清除成功"});
    },
    userinfo: function () {
        dd.navigateTo({
            url: '/pages/my/userinfo/index',
        })
    },
    message: function () {
        dd.navigateTo({
            url: '/pages/my/message/index'
        })
    },
    help: function () {
        dd.navigateTo({
            url: '/pages/my/help/index'
        })
    }
});