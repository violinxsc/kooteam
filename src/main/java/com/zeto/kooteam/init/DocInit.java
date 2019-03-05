package com.zeto.kooteam.init;

import com.zeto.*;
import com.zeto.domain.ZenUser;
import com.zeto.driver.ZenStorageEngine;


public class DocInit {
    private static final int maxtime = 1440;

    public static void execute(ZenUser user) {
        String cacheID = "userDoc" + user.getUid();
        if (ZenCache.get(cacheID) != null) {
            return;
        }
        ZenStorageEngine zenStorageEngine = Zen.getStorageEngine();
        if (ZenEnvironment.isOnline()) {
            ZenCache.set(cacheID, "MgCondition", maxtime);
        }

        // 添加初期数据
        String createId, editFlowId, editMindId, aboutKooId, flowExampleId, mindExampleId, parentId;
        ZenData data = ZenData.put("title", "如何使用Kooteam");
        data.set("uid", user.getUid());
        data.set("type", "4");
        data.set("parentId", "0");
        ZenResult result = zenStorageEngine.execute("put/note", data, user);
        parentId = result.get("_id");
        // 同步关联用户
        ZenData params = ZenData.put("noteId", parentId).set("uid", user.getUid());
        zenStorageEngine.execute("put/noteUser", params, user);


        ZenData example = ZenData.put("uid", user.getUid());
        example.set("title", "如何创建知识库");
        example.set("chapterId", "8");
        example.set("parentId", parentId);
        example.set("content", "\u003cp style\u003d\"margin-left: 40px; text-align: center;\"\u003e\u003cspan style\u003d\"font-size: 1.5em;\"\u003e如何创建「知识库」\u003c/span\u003e\u003c/p\u003e\u003cp style\u003d\"margin-left: 40px;\"\u003e只需简单的三步，即可创建属于自己的知识库。\u003c/p\u003e\u003cp style\u003d\"margin-left: 80px;\"\u003e第一步：点击【+】，输入名称。\u003c/p\u003e\u003cp style\u003d\"margin-left: 80px;\"\u003e第二步：点击【编辑】，选择【新增章节】\u003c/p\u003e\u003cp style\u003d\"margin-left: 80px;\"\u003e第三步：点击【 文件名】，选择文件类型。\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"创建知识库.png\" src\u003d\"//img.yimiyisu.com/5b97/a8/0498d6d220468ad5ad.png\" width\u003d\"1000\" height\u003d\"516.3675\"\u003e\u003cbr\u003e\u003c/p\u003e");
        createId = zenStorageEngine.execute("put/note", example, user).get("_id");

        example.set("title", "如何编辑流程图");
        example.set("chapterId", "3");
        example.set("parentId", parentId);
        example.set("content", "\u003cp style\u003d\"margin-left: 400px;\"\u003e\u003cspan style\u003d\"font-size: 1.5em;\"\u003e如何编辑「流程图」\u003c/span\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u003cb\u003e添加节点\u003c/b\u003e。点击图形，拖动鼠标。如下图所示：\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"流程图-添加图形.png\" src\u003d\"//img.yimiyisu.com/5b98/69/3798d6d220468ad5c0.png\" width\u003d\"1000\" height\u003d\"783.5294117647059\"\u003e\u003c/p\u003e\u003cp\u003e\u003cb\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;添加连线\u003c/b\u003e。点击节点，拖拽连接点，至另一个图形，即可完成连线。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"流程图-连线.png\" src\u003d\"//img.yimiyisu.com/5b98/6c/2f98d6d220468ad5c2.png\" width\u003d\"1000\" height\u003d\"782.0809248554913\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cb\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;放大图形\u003c/b\u003e。拖拽放大点，即可放大图形。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"流程图-放大.png\" src\u003d\"//img.yimiyisu.com/5b98/6c/1698d6d220468ad5c1.png\" width\u003d\"1000\" height\u003d\"782.0809248554913\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cb\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;添加文本\u003c/b\u003e。双击图形或连线，即可添加文本。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"流程图-文本.png\" src\u003d\"//img.yimiyisu.com/5b98/6d/8098d6d220468ad5c3.png\" width\u003d\"1000\" height\u003d\"771.4786674459381\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cb\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;删除元素\u003c/b\u003e。单击图形或文本，按【delete】键。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"流程图-删除.png\" src\u003d\"//img.yimiyisu.com/5b98/6e/9998d6d220468ad5c4.png\" width\u003d\"1000\" height\u003d\"776.4842840512224\"\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb\u003e 修改图形或连线颜色\u003c/b\u003e。文本编辑状态下，单击颜色选择按钮。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"流程图-修改颜色.png\" src\u003d\"//img.yimiyisu.com/5b98/6f/9a98d6d220468ad5c5.png\" width\u003d\"1000\" height\u003d\"743.0875576036866\"\u003e\u003cbr\u003e\u003c/p\u003e");
        editFlowId = zenStorageEngine.execute("put/note", example, user).get("_id");
        example.set("title", "如何编辑脑图");
        example.set("parentId", parentId);
        example.set("chapterId", "11");
        example.set("content", "\u003cp style\u003d\"text-align: center;\"\u003e\u003cspan style\u003d\"font-size: 1.5em;\"\u003e如何编辑「脑图」\u003c/span\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb\u003e 添加节点\u003c/b\u003e。选中节点，按【Enter】键，即可添加子节点。按【tab】键，添加同级节点。如何编辑「脑图」\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"脑图-新增节点.png\" src\u003d\"//img.yimiyisu.com/5b98/61/a298d6d220468ad5b9.png\" width\u003d\"1000\" height\u003d\"763.3711507293355\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb\u003e删除节点\u003c/b\u003e。选中节点，按【delete】键。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"脑图-删除节点.png\" src\u003d\"//img.yimiyisu.com/5b98/60/af98d6d220468ad5b7.png\" width\u003d\"1000\" height\u003d\"763.3711507293355\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb\u003e文本编辑\u003c/b\u003e。双击节点，进入文本编辑状态。\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb\u003e修改颜色\u003c/b\u003e。文本编辑状态下，点击右下角彩色按钮。\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"脑图-修改颜色.png\" src\u003d\"//img.yimiyisu.com/5b98/61/b998d6d220468ad5ba.png\" width\u003d\"1000\" height\u003d\"877.2077375946174\"\u003e\u003cbr\u003e\u003c/p\u003e");
        editMindId = zenStorageEngine.execute("put/note", example, user).get("_id");
        example.set("title", "关于Kooteam");
        example.set("parentId", parentId);
        example.set("chapterId", "2");
        example.set("content", "\u003ch1 style\u003d\"text-align: center;\"\u003e\u003cspan style\u003d\"color: rgb(77, 128, 191); font-size: 1.5em;\"\u003e\u003cb\u003eKOOTEAM\u003c/b\u003e\u003c/span\u003e\u003c/h1\u003e\u003cp\u003e\u003cspan style\u003d\"\"\u003e\u003cbr\u003e\u003c/span\u003e\u003c/p\u003e\u003cp style\u003d\"text-align: center;\"\u003e\u003cspan style\u003d\"font-size: 1.25em;\"\u003e协作与日程管理平台\u003c/span\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cspan style\u003d\"font-size: 1.25em;\"\u003e\u003cbr\u003e\u003c/span\u003e\u003c/p\u003e\u003ch2\u003e\u003cspan style\u003d\"font-size: 1.25em;\"\u003e\u003cspan style\u003d\"color: rgb(77, 128, 191);\"\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; 功能摘要\u003c/span\u003e\u003c/span\u003e\u003c/h2\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u0026nbsp;\u003cimg alt\u003d\"Screen Shot 2018-09-06 at 2.58.28 PM.png\" src\u003d\"//img.yimiyisu.com/5b98/75/5e98d6d220468ad5c8.png\" width\u003d\"150\" height\u003d\"142.0754716981132\"\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb style\u003d\"color: rgb(51, 51, 51); font-size: x-large;\"\u003e日程安排\u003c/b\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;个人事项、工作计划、项目任务\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp style\u003d\"margin-left: 160px;\"\u003e\u003cspan style\u003d\"color: rgb(77, 128, 191); font-size: 1.5em;\"\u003e\u003cb\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u003cimg alt\u003d\"Screen Shot 2018-09-06 at 2.56.42 PM.png\" src\u003d\"//img.yimiyisu.com/5b98/76/2998d6d220468ad5c9.png\" width\u003d\"150\" height\u003d\"142.60089686098655\"\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u003c/b\u003e\u003c/span\u003e\u003cb style\u003d\"font-size: x-large;\"\u003e项目管理\u003c/b\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;项目看板、成员管理、任务分配\u003c/p\u003e\u003cp style\u003d\"margin-left: 160px;\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp style\u003d\"margin-left: 160px;\"\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"Screen Shot 2018-09-06 at 3.00.46 PM.png\" src\u003d\"//img.yimiyisu.com/5b98/76/a198d6d220468ad5ca.png\" width\u003d\"150\" height\u003d\"171.1267605633803\"\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb style\u003d\"font-size: x-large;\"\u003e文档中心\u0026nbsp;\u003c/b\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;文本、流程图、脑图\u003c/p\u003e\u003ch2\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb\u003e1.日程安排\u0026nbsp;\u003c/b\u003e\u0026nbsp;\u003c/h2\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; 待办事件分轻重缓急，一目了然，帮助你及时完成工作或者生活中的事项。\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"工作四象限.jpg\" src\u003d\"//img.yimiyisu.com/5b98/7c/9e98d6d220468ad5ce.jpg\" width\u003d\"1000\" height\u003d\"537.8735232800556\"\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;还可以切换周视图，月视图\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"月视图.jpg\" src\u003d\"//img.yimiyisu.com/5b98/7e/d198d6d220468ad5cf.jpg\" width\u003d\"1000\" height\u003d\"556.636553161918\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp;\u003cb style\u003d\"font-size: x-large;\"\u003e 2.项目管理\u003c/b\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp;通过简洁明了的卡片，帮助你对项目进度了如指掌。\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"项目卡片.jpg\" src\u003d\"//img.yimiyisu.com/5b98/86/9a98d6d220468ad5d0.jpg\" width\u003d\"1000\" height\u003d\"541.029207232267\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; 项目看板。\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"看板截图.jpg\" src\u003d\"//img.yimiyisu.com/5b98/8a/1d98d6d220468ad5d1.jpg\" width\u003d\"1000\" height\u003d\"511.1265646731572\"\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp;\u003cb style\u003d\"font-size: x-large;\"\u003e 3.文档中心\u003c/b\u003e\u003cb style\u003d\"font-size: x-large;\"\u003e\u003cbr\u003e\u003c/b\u003e\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp; \u0026nbsp; \u0026nbsp; 自定义目录结构。可以创建 文本文档，流程图，脑图。\u003c/p\u003e\u003cp\u003e\u0026nbsp; \u0026nbsp;\u003cimg alt\u003d\"知识库.jpg\" src\u003d\"//img.yimiyisu.com/5b98/8b/b798d6d220468ad5d2.jpg\" width\u003d\"1000\" height\u003d\"520.5003474635163\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003cp style\u003d\"margin-left: 160px;\"\u003e\u003cbr\u003e\u003c/p\u003e\u003cp style\u003d\"margin-left: 160px;\"\u003e\u003cspan style\u003d\"color: rgb(77, 128, 191); font-size: 1.5em;\"\u003e\u003cb\u003e\u003cbr\u003e\u003c/b\u003e\u003c/span\u003e\u003c/p\u003e\u003cp style\u003d\"margin-left: 160px;\"\u003e\u003cspan style\u003d\"color: rgb(77, 128, 191); font-size: 1.5em;\"\u003e\u003cb\u003e\u0026nbsp;\u0026nbsp;\u003cbr\u003e\u003c/b\u003e\u003c/span\u003e\u003c/p\u003e");
        aboutKooId = zenStorageEngine.execute("put/note", example, user).get("_id");
        example.set("title", "流程图示例");
        example.set("parentId", parentId);
        example.set("chapterId", "12");
        example.set("type", "3");
        example.set("content", "{\"nodes\":[{\"x\":210,\"y\":350,\"type\":\"rect\",\"width\":80,\"height\":48,\"id\":\"shape_8451\",\"color\":\"#009fe3\",\"text\":\"收到需求\"},{\"x\":388,\"y\":338,\"type\":\"angle4\",\"width\":80,\"height\":72,\"id\":\"shape_8453\",\"color\":\"#f80e15\",\"text\":\"有把握\"},{\"x\":388,\"y\":168,\"type\":\"angle4\",\"width\":80,\"height\":72,\"id\":\"shape_8456\",\"color\":\"#f80e15\",\"text\":\"需求合理\"},{\"x\":387,\"y\":20,\"type\":\"rect\",\"width\":80,\"height\":48,\"id\":\"shape_8459\",\"color\":\"#009fe3\",\"text\":\"做\"},{\"x\":664,\"y\":20,\"type\":\"ellipse\",\"width\":80,\"height\":48,\"id\":\"shape_8461\",\"color\":\"#E7C004\",\"text\":\"全量发布\"},{\"x\":989,\"y\":8,\"type\":\"angle4\",\"width\":80,\"height\":72,\"id\":\"shape_8463\",\"color\":\"#f80e15\",\"text\":\"达到预期\"},{\"x\":527,\"y\":350,\"type\":\"step\",\"width\":106,\"height\":48,\"id\":\"shape_8465\",\"color\":\"#388bdd\",\"text\":\"进一步调研\"},{\"x\":679,\"y\":338,\"type\":\"angle4\",\"width\":80,\"height\":72,\"id\":\"shape_8467\",\"color\":\"#f80e15\",\"text\":\"值得尝试\"},{\"x\":846,\"y\":350,\"type\":\"step\",\"width\":100,\"height\":48,\"id\":\"shape_8469\",\"color\":\"#388bdd\",\"text\":\"小步迭代\\n灰度测试\"},{\"x\":991,\"y\":350,\"type\":\"step\",\"width\":109,\"height\":48,\"id\":\"shape_8471\",\"color\":\"#388bdd\",\"text\":\"效果评估\"},{\"x\":821,\"y\":512,\"type\":\"document\",\"width\":150,\"height\":52,\"id\":\"shape_8473\",\"color\":\"#e17aff\",\"text\":\"客户端：发布内测版本\"},{\"x\":679,\"y\":180,\"type\":\"rect\",\"width\":80,\"height\":48,\"id\":\"shape_8475\",\"color\":\"#009fe3\",\"text\":\"不做\"}],\"lines\":[{\"start\":\"shape_8451\",\"end\":\"shape_8453\",\"text\":\"\"},{\"start\":\"shape_8453\",\"end\":\"shape_8465\",\"text\":\"否\"},{\"start\":\"shape_8465\",\"end\":\"shape_8467\",\"text\":\"\"},{\"start\":\"shape_8467\",\"end\":\"shape_8469\",\"text\":\"是\"},{\"start\":\"shape_8469\",\"end\":\"shape_8471\",\"text\":\"\"},{\"start\":\"shape_8471\",\"end\":\"shape_8463\",\"text\":\"\"},{\"start\":\"shape_8463\",\"end\":\"shape_8461\",\"text\":\"是\"},{\"start\":\"shape_8453\",\"end\":\"shape_8456\",\"text\":\"是\"},{\"start\":\"shape_8456\",\"end\":\"shape_8459\",\"text\":\"是\"},{\"start\":\"shape_8459\",\"end\":\"shape_8461\",\"text\":\"\"},{\"start\":\"shape_8456\",\"end\":\"shape_8475\",\"text\":\"否\"},{\"start\":\"shape_8467\",\"end\":\"shape_8475\",\"text\":\"否\"},{\"start\":\"shape_8469\",\"end\":\"shape_8473\",\"text\":\"\"}]}");
        flowExampleId = zenStorageEngine.execute("put/note", example, user).get("_id");
        example.set("title", "脑图示例");
        example.set("parentId", parentId);
        example.set("chapterId", "13");
        example.set("type", "2");
        example.set("content", "{\"id\":\"root\",\"name\":\"快速记忆法\",\"shape\":\"\",\"children\":[{\"children\":[{\"children\":[],\"name\":\"编故事记忆法（又称导演记忆法）\",\"color\":\"#62B0FF\",\"id\":\"i6896\",\"height\":32,\"width\":215,\"left\":true},{\"children\":[],\"name\":\"连锁记忆法\",\"color\":\"#62B0FF\",\"id\":\"i6898\",\"height\":32,\"width\":85,\"left\":true},{\"children\":[],\"name\":\"定桩法\",\"color\":\"#62B0FF\",\"id\":\"i6899\",\"height\":32,\"width\":59,\"left\":true},{\"children\":[],\"name\":\"口诀记忆法\",\"color\":\"#62B0FF\",\"id\":\"i6900\",\"height\":32,\"width\":85,\"left\":true},{\"children\":[],\"name\":\"首字母记忆法n\",\"color\":\"#62B0FF\",\"id\":\"i6902\",\"height\":32,\"width\":98,\"left\":true},{\"children\":[],\"name\":\"归纳记忆法\",\"color\":\"#62B0FF\",\"id\":\"i6904\",\"height\":32,\"width\":85,\"left\":true},{\"children\":[],\"name\":\"图表记忆法\",\"color\":\"#62B0FF\",\"id\":\"i6906\",\"height\":32,\"width\":85,\"left\":true}],\"name\":\"分类\",\"color\":\"#cf0606\",\"id\":\"i6866\",\"height\":356,\"width\":46,\"left\":true},{\"children\":[{\"children\":[],\"name\":\"以物像为根本\",\"color\":\"#ffca65\",\"id\":\"i6816\",\"height\":32,\"width\":98,\"left\":true},{\"children\":[],\"name\":\"以联想为关键\",\"color\":\"#ffca65\",\"id\":\"i6818\",\"height\":32,\"width\":98,\"left\":true},{\"children\":[],\"name\":\"以奇特为秘诀\",\"color\":\"#ffca65\",\"id\":\"i6820\",\"height\":32,\"width\":98,\"left\":true}],\"name\":\"原理\",\"color\":\"#d6337d\",\"id\":\"i6868\",\"height\":140,\"width\":46,\"left\":true},{\"children\":[{\"children\":[],\"name\":\"联想法\",\"color\":\"#ffca65\",\"id\":\"i5190\",\"height\":32,\"width\":59,\"left\":false},{\"children\":[],\"name\":\"谐音法\",\"color\":\"#ffca65\",\"id\":\"i6800\",\"height\":32,\"width\":59,\"left\":false},{\"children\":[],\"name\":\"联结法\",\"color\":\"#ffca65\",\"id\":\"i6802\",\"height\":32,\"width\":59,\"left\":false},{\"children\":[],\"name\":\"罗马房法\",\"color\":\"#ffca65\",\"id\":\"i6803\",\"height\":32,\"width\":72,\"left\":false}],\"name\":\"四种常用方法\",\"color\":\"#cf0606\",\"id\":\"i6870\",\"height\":194,\"width\":98,\"left\":false},{\"children\":[{\"children\":[{\"children\":[],\"name\":\"最佳食物有瘦肉、鸡蛋、豆制品、鱼、贝类等\",\"color\":\"#62B0FF\",\"id\":\"i6845\",\"height\":32,\"width\":280,\"left\":false}],\"name\":\"蛋白质类食物\",\"color\":\"#56baff\",\"id\":\"i6834\",\"height\":32,\"width\":98,\"left\":false},{\"children\":[{\"children\":[],\"name\":\"最佳食物有鱼、瘦肉、鸡蛋（特别是蛋黄）等\",\"color\":\"#62B0FF\",\"id\":\"i6847\",\"height\":32,\"width\":280,\"left\":false}],\"name\":\"含胆碱丰富的食物n\",\"color\":\"#56baff\",\"id\":\"i6836\",\"height\":32,\"width\":124,\"left\":false},{\"children\":[{\"children\":[],\"name\":\"最佳食物有脑类、蛋黄、芝麻、花生等\",\"color\":\"#62B0FF\",\"id\":\"i6849\",\"height\":32,\"width\":241,\"left\":false}],\"name\":\"含卵磷脂丰富的食物\",\"color\":\"#56baff\",\"id\":\"i6838\",\"height\":32,\"width\":137,\"left\":false},{\"children\":[{\"children\":[],\"name\":\"最佳食物有豆类、荞麦、坚果类、麦芽等\",\"color\":\"#62B0FF\",\"id\":\"i6851\",\"height\":32,\"width\":254,\"left\":false}],\"name\":\"含镁含钙食物\",\"color\":\"#56baff\",\"id\":\"i6840\",\"height\":32,\"width\":98,\"left\":false},{\"children\":[{\"children\":[],\"name\":\"富含维生素的食物有新鲜蔬菜、水果等\",\"color\":\"#62B0FF\",\"id\":\"i6853\",\"height\":32,\"width\":241,\"left\":false}],\"name\":\"多食碱性和富含维生素的食物\",\"color\":\"#56baff\",\"id\":\"i6842\",\"height\":32,\"width\":189,\"left\":false}],\"name\":\"相关食物\",\"color\":\"#cf0606\",\"id\":\"i6872\",\"height\":248,\"width\":72,\"left\":false}],\"lineType\":1,\"grapType\":1,\"height\":442,\"width\":85,\"color\":\"#7B8F18\",\"ids\":1}");
        mindExampleId = zenStorageEngine.execute("put/note", example, user).get("_id");

        data = ZenData.put("_id", parentId);
        data.set("content", "{\"id\":13,\"sons\":[{\"title\":\"欢迎使用\",\"link\":\"folder\",\"date\":\"2016-09-18\",\"id\":1,\"sons\":[{" +
                "\"title\":\"如何创建「知识库」\",\"link\":\"" + createId + "\",\"date\":\"\",\"sons\":[],\"id\":8},{" +
                "\"title\":\"如何编辑「流程图」\",\"id\":3,\"link\":\"" + editFlowId + "\",\"date\":\"2016-09-18\",\"sons\":[]},{" +
                "\"title\":\"如何编辑「脑图」\",\"link\":\"" + editMindId + "\",\"date\":\"\",\"sons\":[],\"id\":11}]},{" +
                "\"title\":\"关于kooteam\",\"id\":2,\"link\":\"" + aboutKooId + "\",\"date\":\"2016-09-18\",\"sons\":[{" +
                "\"title\":\"流程图示例\",\"link\":\"" + flowExampleId + "\",\"date\":\"\",\"sons\":[],\"id\":12},{" +
                "\"title\":\"脑图示例\",\"link\":\"" + mindExampleId + "\",\"date\":\"\",\"sons\":[],\"id\":13}]}]}");
        zenStorageEngine.execute("patch/note", data, user);
    }
}
