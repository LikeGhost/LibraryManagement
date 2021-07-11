<%--
  Created by IntelliJ IDEA.
  User: 11540
  Date: 2021/7/8
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>管理员界面</title>
  <link href="https://cdn.jsdelivr.net/npm/layui-src@2.4.5/dist/css/layui.css" rel="stylesheet"/>
  <link href="http://lowcode.magicalcoder.com/magicalcoder/assets/drag/ui/magicalcoder/1.1.0/magicalcoder.css"
        rel="stylesheet"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/json3/3.3.3/json3.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.6.0/echarts.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.6.0/extension/dataTool.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/layui-src@2.4.5/dist/layui.all.js"></script>
  <script src="http://www.magicalcoder.com/assets/js/common.js"></script>
  <script src="http://lowcode.magicalcoder.com/magicalcoder/assets/drag/ui/magicalcoder/1.1.0/magicalcoder.js"></script>
  <script src="/libraryManagement/static/js/jquery-3.6.0.js"></script>
  <link rel="stylesheet" href="/libraryManagement/static/layui/css/layui.css" media="all">
  <script src="/libraryManagement/static/layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript">
    $(function () {
      $(function () {
        var rc ="${role.rContent}";
        if (rc.indexOf("管理员") != -1) {
          $("#detail").text("管理员详情");
        }
      })
    })
  </script>
  <script>
    layui.use('element', function () {
      var $ = layui.jquery
              , element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

      //触发事件
      var active = {
        detailAdd: function () {
          //新增一个Tab项
          element.tabAdd('funcTab', {
            title: '详情'
            ,
            content: '<iframe src="/libraryManagement/userDetail.jsp" width="1200px" height="700px" frameborder="0"></iframe>'

            ,
            id: 'tab' + new Date().getTime()
          });

        },
        allBookAdd: function () {
          //新增一个Tab项
          element.tabAdd('funcTab', {
            title: '添加图书信息'
            ,
            content: '<iframe src="/libraryManagement/addBookInformation.jsp" width="1200px" height="700px" frameborder="0"></iframe>'
            ,
            id: 'tab' + new Date().getTime()
          });

        },

        allBookInformation: function () {
          //新增一个Tab项
          element.tabAdd('funcTab', {
            title: '所有图书信息'
            ,
            content: '<iframe src="/libraryManagement/allBookInformation.jsp" width="1200px" height="700px" frameborder="0"></iframe>'
            ,
            id: 'tab' + new Date().getTime()
          });

        },allBorrowRecord: function () {
          //新增一个Tab项
          element.tabAdd('funcTab', {
            title: '借阅记录'
            ,
            content: '<iframe src="/libraryManagement/allBorrowRecord.jsp" width="1200px" height="700px" frameborder="0"></iframe>'
            ,
            id: 'tab' + new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
          });

        },

         tabDelete: function (othis) {
          //删除指定Tab项
          element.tabDelete('fucTab', '44'); //删除：“商品管理”


          othis.addClass('layui-btn-disabled');
        }
        , tabChange: function () {
          //切换到指定Tab项
          element.tabChange('funcTab', '22'); //切换到：用户管理
        }
      };

      $('.site-demo-active').on('click', function () {
        var othis = $(this), type = othis.data('type');
        active[type] ? active[type].call(this, othis) : '';
      });

      //Hash地址的定位
      var layid = location.hash.replace(/^#test=/, '');
      element.tabChange('test', layid);

      element.on('tab(test)', function (elem) {
        location.hash = 'test=' + $(this).attr('lay-id');
      });

    });
  </script>


</head>
<body class="layui-form" style="">
<div id="magicalDragScene" class="mc-root mc-ui-absolute-pane">
  <div class="layui-row" style="position: absolute; left: 0%; top: 0%;width:100%
">
    <div class="layui-col-xs12 mc-ui-flex-center layui-col-lg12 layui-bg-black"
         style="height: 80px; font-size: 32px;">图书管理系统
    </div>
    <div class="layui-col-xs12">
      <div class="layui-row" style="width: 100%; height: 100%;">
        <div class="layui-col-md6 layui-col-lg2" style="height: 800px;">
          <ul class="layui-nav layui-nav-tree" style="height: 800px;">
            <li class="layui-nav-item">
              <a id="detail" class="site-demo-active " data-type="detailAdd">管理员详情</a>
            </li>
            <li class="layui-nav-item">
              <a class="site-demo-active " data-type="allBookAdd">添加图书</a>

            </li>
            <li class="layui-nav-item">
              <a class="site-demo-active " data-type="allBookInformation">所有图书信息</a>

            </li>
            <li class="layui-nav-item">
              <a class="site-demo-active " data-type="allBorrowRecord">借阅记录</a>

            </li>

            <li class="layui-nav-item">
              <a class="site-demo-active" href="login/logout">注销</a>

            </li>
            <li id="uuid85b76a21-71d6-4d09-94eb-b7d85209990c" class="layui-nav-item">
              <a href="javascript:;">新菜单</a>
              <dl class="layui-nav-child">
                <dd>
                  <a>地址1</a>
                </dd>
                <dd>
                  <a>地址2</a>
                </dd>
              </dl>
            </li>
          </ul>
        </div>
        <div class="layui-col-md6 layui-col-lg10" style="height: 800px;">
          <div class="layui-tab" lay-filter="funcTab" style="width: 100%; height: 800px;"
               lay-allowclose="true">
            <ul class="layui-tab-title">


            </ul>
            <div class="layui-tab-content">

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>
<script>
  //以下脚本为标签属性转换成layui组件的还原过程
  //调试:打开浏览器控制台(F12),在代码中某行增加 debugger 即可调试
  var $ = layui.jquery, laytpl = layui.laytpl, laydate = layui.laydate, form = layui.form, layedit = layui.layedit,
          slider = layui.slider, element = layui.element, colorpicker = layui.colorpicker, upload = layui.upload,
          rate = layui.rate, carousel = layui.carousel, table = layui.table, flow = layui.flow;
  var magicalDragLayuiUtil = {
    rebuildLayUiControls: function () {
      var _t = this;
      //日期
      $(".magicalcoder-laydate").each(function (idx, item) {
        laydate.render(_t.iteratorAttr({
          elem: item
        }, item));
      })
      //富文本
      $(".magicalcoder-layedit").each(function (idx, item) {
        var mcDataId = $(item).attr("id");
        if (mcDataId) {
          layedit.build(mcDataId, {
            height: 300
          });
        }
      })
      //外键
      $(".magicalcoder-foreign-select2").each(function (idx, item) {
        var mcDataId = $(item).attr("id");
        if (mcDataId) {
          $("#" + mcDataId).select2({
            allowClear: true,
            width: "150px",
            delay: 500,
          });
        }
      })
      //颜色选择器
      $(".magicalcoder-color-picker").each(function (idx, item) {
        colorpicker.render(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //上传组件
      $(".magicalcoder-layupload").each(function (idx, item) {
        upload.render(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //滑块
      $(".magicalcoder-slider").each(function (idx, item) {
        slider.render(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //评分
      $(".magicalcoder-rate").each(function (idx, item) {
        rate.render(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //轮播
      $(".layui-carousel").each(function (idx, item) {
        carousel.render(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //流加载
      $(".magicalcoder-flow").each(function (idx, item) {
        flow.load(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //代码
      $(".magicalcoder-code").each(function (idx, item) {
        layui.code(_t.iteratorAttr({
          elem: $(item)
        }, item));
      })
      //弹窗
      $(".magicalcoder-layer").each(function (idx, item) {
        //先隐藏起来
        $(this).next().hide();
        $(this).click(function () {
          var config = _t.iteratorAttr({
            elem: $(item)
          }, item);
          var type = config.type;
          if (type + '' == 1) {
            config.content = $(this).next();
            if (!config.content.hasClass("magicalcoder-layer-content")) {
              config.content = config.content.find(".magicalcoder-layer-content")
            }
          }
          if (config.btn) {
            config.btn = config.btn.split(",")
          }
          if (config.area) {
            config.area = config.area.split(",")
          }
          layer.open(config)
        })
      })
      //动态表格 我们单独封装了layui-table的初始化方式 至于数据排序 返回格式 等操作请根据你的具体环境自行封装
      $(".magicalcoder-table").each(function (idx,
                                              item) {
        var cols = [];
        //读取列配置
        $(this).find(".magicalcoder-table-th").each(function (i, th) {
          cols.push(_t.iteratorAttr({
            title: $(this).text()
          }, th));
        })
        var tableConfig = _t.iteratorAttr({
                  elem: $(item),
                  cols: [cols]
                },
                item);
        //初始化表格 至于返回的数据格式 您可以根据自己的系统自行改造 这里仅做一个示例 参考js\\data\\list.json
        table.render(tableConfig);
      })
      //部分组件初始化
      element.init();
      //表单初始化
      form.render();
    },
    //将标签上的属性 转换成layui函数初始化时的参数名:参数值
    iteratorAttr: function (renderConfig, dom) {
      var attrs = dom.attributes;
      for (var i = 0; i < attrs.length; i++) {
        var attr = attrs[i];
        var name = attr.name;
        var value = attr.value;
        if (name.indexOf("mc-") === 0) {
          name = name.replace("mc-attr-", '');
          name = name.replace("mc-event-", '');
          if (name.indexOf('str-') === 0) {
            name = name.replace('str-', '');
          } else if (name.indexOf('bool-') === 0) {
            name = name.replace('bool-', '');
            value == 'true' || value === '' ? value = true : value = value;
            value == 'false' ? value = false : value = value;
          } else if (name.indexOf('num-') === 0) {
            name = name.replace('num-', '');
            if (value !== '' && !isNaN(value)) {
              value = parseFloat(value);
            }
          } else if (name.indexOf('json-') === 0) {
            name = name.replace('json-', '');
            if (value !== '') {
              value = JSON.parse(value);
            }
          }
          renderConfig[this.htmlAttrNameToTuoFeng(name)] = value;
        }
      }
      return renderConfig;
    },
    //user-name -> userName html上的标签名转换成驼峰名称
    htmlAttrNameToTuoFeng: function (name) {
      var arr = name.split("-");
      var newArr = []
      for (var i = 0; i < arr.length; i++) {
        if (i != 0) {
          if (arr[i] != '') {
            newArr.push(this.firstCharToUpLower(arr[i]));
          }
        } else {
          newArr.push(arr[i]);
        }
      }
      return newArr.join('');
    },
    //首字母大写
    firstCharToUpLower: function (name) {
      var arr = name.split("");
      arr[0] = arr[0].toUpperCase();
      return arr.join('');
    },
  }
  magicalDragLayuiUtil.rebuildLayUiControls();
  //echarts自动初始化
  new McECharts().render();
  //functions-begin
  //functions-end
</script>
</body>

</html>