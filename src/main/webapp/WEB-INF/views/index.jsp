<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,header-user-scalable=no"/>
    <meta content="telephone=no,email=no" name="format-detection"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>

    <meta name="renderer" content="webkit">
    <script type="text/javascript" src="/assets/plugins/jquery-2.1.4.js"></script>

    <link rel="stylesheet" href="/assets/plugins/iconfont/iconfont.css"/>

    <link rel="stylesheet" href="lib/prism/prism.css"/>

    <script type="text/javascript" src="/assets/plugins/webuploader.min.js"></script>

    <link rel="stylesheet" href="/assets/css/xstarp.css"/>
    <script type="text/javascript" src="/assets/js/xstarp.js"></script>
    <style>
        /*@charset "UTF-8";*/
        body {
            font-family: "Microsoft YaHei", "Arial", sans-serif;
            color: #464646;
        }

        /*头部*/
        .header {
            position: fixed;
            width: 100%;
            height: 60px;
            top: 0;
            padding: 0 20px;
            background: #f5f5f5;
            border-bottom: 1px solid #e6e6e6;
            z-index: 10;
        }

        .header-logo {
            display: block;
            float: left;
            height: 100%;
        }

        .header-logo img {
            vertical-align: middle;
            margin-top: 10px;
        }

        .header-user {
            position: relative;
            float: right;
            width: 170px;
            height: 100%;
            padding-left: 10px;
            padding-top: 7px;
            box-sizing: border-box;
            border-left: 1px solid #dee1ea;
            font-size: 12px;
            color: #585b5d;
        }

        .header-user img {
            display: inline-block;
            vertical-align: middle;
        }

        .header-user p {
            display: inline-block;
            padding: 0 10px;
        }

        .header-user span {
            display: inline-block;
            width: 10px;
            height: 10px;
            background: url(/assets/img/icon_arrow.png) no-repeat center;
        }

        .header-user-name {
            display: inline-block;
            cursor: pointer;
        }

        .header-user-avatar {
            width: 45px;
            height: 45px;
        }

        .header-user-more {
            display: none;
            position: absolute;
            top: 45px;
            right: 20px;
            width: 100px;
            border: 1px solid #e4e4e4;
            border-radius: 3px;
            background: #fff;
            color: #000;
            text-align: left;
        }

        .header-user-more a {
            line-height: 20px;
            color: #585b5d;
            display: block;
            padding: 6px 0 6px 16px;
        }

        .header-user-more a:hover {
            color: #db2828;
        }

        .header-user-uparrow {
            position: absolute;
            top: -8px;
            right: 8px;
        }

        .header-rt {
            float: right;
            position: relative;
            height: 100%;;
            width: 6.7%;
            border-left: 1px solid #dee1ea;
        }

        .header-rt a {
            display: block;
            height: 100%;
        }

        .header-rt .num {
            position: absolute;
            width: 18px;
            height: 18px;
            top: 10px;
            right: 20px;
            line-height: 18px;
            font-size: 13px;
            color: #fff;
            text-align: center;
            background: url(/assets/img/mail_msg.png);
        }

        .header-mail {
            background: url(/assets/img/mail.png) no-repeat center;
        }

        .header-msg {
            background: url(/assets/img/signal.png) no-repeat center;
        }

        .header-msg .num {
            background: url(/assets/img/signal_msg.png);
        }

        .header-mail .num {
            background: url(/assets/img/mail_msg.png);
        }

        /*侧边栏*/

        .aside {
            width: 220px;
            position: fixed;
            height: 100%;
            top: 60px;
            bottom: 0;
            left: 0;
            background: #444d58;
            border-right: 1px solid #e6e6e6;
            z-index: 102;
            overflow-x: hidden;
        }

        .aside-con {
            height: 100%;
            overflow: auto;
            overflow-x: hidden;
        }

        .aside-head {
            height: 60px;
            line-height: 60px;
            color: #fff;
            background: url(/assets/img/icon_menu_arrow.png) no-repeat 192px;
            border-bottom: 1px solid #353b45;
            text-indent: 55px;
            cursor: pointer;
        }

        .aside-head i {
            margin-right: 10px;
        }

        .aside-head a {
            display: block;
        }

        /*.aside span{display:block;text-indent:55px;}*/

        .aside-body {
            display: none;
        }

        .aside-body.cur {
            display: block;
        }

        .aside-body a {
            display: block;
            width: 100%;
            line-height: 41px;
            text-indent: 55px;
            color: #9ca3ac;
            background: #353b45;
        }

        .aside-body a:hover {
            color: #fff;
            background: #777f89;
        }

        .aside-body a.cur {
            color: #fff;
            background: #777f89;
        }

        /*.aside-sy{background:url(img/user.png) no-repeat 20px center;}*/

        .content {
            margin-left: 240px;
            margin-top: 70px;
            margin-right: 20px;
            margin-bottom: 20px;
        }

    </style>


</head>
<body>
<div class="header">
    <a href="#" class="header-logo"><img src="/assets/img/logo.png"></a>


    <div class="header-user">
        <img class="header-user-avatar" src="/assets/img/head_user.png">
        <div class="header-user-name"><p>管理员</p><span></span></div>

        <div class="header-user-more">
            <img src="/assets/img/sign_out_bg.png" alt="" class="header-user-uparrow">
            <a href="#">
                <img src="/assets/img/switch_icon.png" alt="" class=""> 关于我们
            </a>
            <!--            <a href="#" class="header-user-quit">-->
            <!--                <img src="img/sign_out_icon.png" alt="" class=""> 退出-->
            <!--            </a>-->
        </div>
    </div>
    <div class="header-rt header-mail "><a href="#">
        <div class="num">2</div>
    </a></div>
    <div class="header-rt header-msg "><a href="#">
        <div class="num">6</div>
    </a></div>
</div>

<div class="aside">
    <div class="aside-con">
        <p class="aside-head"><a href="index.php"><i class="iconfont icon-shouye"></i>首页</a></p>
        <p class="aside-head"><i class="iconfont icon-shouye"></i>样式</p>
        <div class="aside-body ">
            <a href="base.php" class="">基础css</a>
            <a href="button.php" class="">按钮</a>
            <a href="tip.php" class="">贴士</a>
            <a href="alert.php" class="">提示</a>
            <a href="form.php" class="">表单元素</a>
            <a href="page.php" class="">分页</a>
            <a href="progress.php" class="">进度条</a>
        </div>
        <p class="aside-head"><i class="iconfont icon-shouye"></i>结构</p>
        <div class="aside-body ">
            <a href="grid.php" class="">栅栏</a>
            <a href="nav.php" class="">导航</a>
            <a href="tab.php" class="">标签页</a>
            <a href="panel.php" class="">面板</a>
            <a href="title.php" class="">标题</a>
        </div>
        <p class="aside-head"><i class="iconfont icon-shouye"></i>插件</p>
        <div class="aside-body ">
            <!--            <a href="loading.php" class="--><!--">等待</a>-->
            <a href="imgview.php" class="">图片</a>
            <a href="tree.php" class="">树</a>
            <a href="pop.php" class="">弹窗</a>
            <a href="table.php" class="">表格</a>
            <a href="upload.php" class="">文件上传</a>
        </div>
        <p class="aside-head"><i class="iconfont icon-shouye"></i>函数</p>
        <div class="aside-body ">
            <a href="format.php" class="">格式化</a>
            <!--            <a href="console.php" class="--><!--" >页面控制台</a>-->
            <a href="gettime.php" class="">获取时间</a>
            <a href="verify.php" class="">表单验证</a>
        </div>
        <p class="aside-head"><i class="iconfont icon-shouye"></i>封装</p>
        <div class="aside-body ">
            <a href="map.php" class="">地图</a>
            <a href="icon.php" class="">图标</a>
            <a href="ajax.php" class="">Ajax操作</a>
            <a href="chart.php" class="">图表</a>
            <a href="time.php" class="">时间选择器</a>
        </div>


    </div>
</div>

<div class="content">


    <article>
        <section>
            <p class="x-title">如何使用:</p>
            把/assets目录拖进去
        </section>
        <br>

        <section>
            <p class="x-title">常用功能:</p>
            ...
        </section>
        <br>

        <section>
            <p class="x-title"> 关于我们:</p>
            小步创想
        </section>
        <br>

        <section>
            <p class="x-title">待解决问题:</p>
            <ul>
                <li>底层css驱动整体样式</li>
                <li>基础方法方便开发</li>
                <li>数据视图绑定</li>
                <li>模块化</li>
                <li>更新项目</li>
                <li>静态文件缓存</li>
            </ul>

        </section>
    </article>
</div>
<script>
    $(document).ready(function () {
        //左边菜单栏下拉
        $(".aside p.aside-head").click(function () {
            $(this).next("div.aside-body").slideToggle(300).siblings("div.aside-body").slideUp("slow");
        });

        $('.header-user-name').mousedown(function () {
            $('.header-user-more').toggle();
        });
//        $('.header-user').mouseleave(function(){
//            $('.header-user-more').hide();
//        });
    });
</script>
</body>
</html>