(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["search"],{"2d3b":function(e,t,n){"use strict";n.r(t);var a=n("7a23"),r={class:"container"};function c(e,t,n,c,i,o){var d=Object(a["G"])("van-search"),u=Object(a["G"])("video-row"),s=Object(a["G"])("van-list");return Object(a["z"])(),Object(a["g"])("div",r,[Object(a["j"])(d,{modelValue:e.q,"onUpdate:modelValue":t[1]||(t[1]=function(t){return e.q=t}),"show-action":"",shape:"round",background:"#eeeeee",placeholder:"请输入搜索关键词",onSearch:e.handleSearch,onCancel:e.handleBack},null,8,["modelValue","onSearch","onCancel"]),Object(a["j"])(s,{class:"search-result-container","immediate-check":!1,modelValue:e.loading,"onUpdate:modelValue":t[2]||(t[2]=function(t){return e.loading=t}),finished:e.finished,"finished-text":"没有更多了",onLoad:e.handleLoad},{default:Object(a["Q"])((function(){return[(Object(a["z"])(!0),Object(a["g"])(a["a"],null,Object(a["F"])(e.result,(function(t){return Object(a["z"])(),Object(a["g"])(u,{video:t,key:t.id,onClick:function(n){return e.handleVideoRowClick(t.id)}},null,8,["video","onClick"])})),128))]})),_:1},8,["modelValue","finished","onLoad"])])}n("99af"),n("d3b7"),n("25f0"),n("e7e5");var i=n("d399"),o=(n("96cf"),n("1da1")),d=(n("2994"),n("2bdd")),u=(n("5852"),n("d961")),s=n("f9d3"),l=n("c5e7"),p=Object(a["k"])({name:"Search",components:{VanSearch:u["a"],VanList:d["a"],VideoRow:s["a"]},data:function(){return{loading:!1,finished:!1,paging:{page:0,per_page:10},q:"",result:[]}},methods:{getResults:function(){var e=arguments,t=this;return Object(o["a"])(regeneratorRuntime.mark((function n(){var a,r,c,o;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return a=e.length>0&&void 0!==e[0]&&e[0],r=i["a"].loading("加载中..."),n.prev=2,n.next=5,Object(l["m"])({q:t.q,page:t.paging.page,per_page:t.paging.per_page});case 5:c=n.sent,n.next=13;break;case 8:return n.prev=8,n.t0=n["catch"](2),r.clear(),n.abrupt("return");case 13:o=c.data.items,t.result=a?t.result.concat(o):o,t.finished=o.length<t.paging.per_page;case 16:case"end":return n.stop()}}),n,null,[[2,8]])})))()},handleBack:function(){this.$router.back()},handleSearch:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.paging.page=1,e.finished=!1,t.next=4,e.getResults();case 4:return t.next=6,e.$nextTick();case 6:case"end":return t.stop()}}),t)})))()},handleLoad:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!0!==e.loading){t.next=2;break}return t.abrupt("return");case 2:return e.loading=!0,e.paging.page++,t.next=6,e.getResults(!0);case 6:return t.next=8,e.$nextTick();case 8:e.loading=!1;case 9:case"end":return t.stop()}}),t)})))()},handleVideoRowClick:function(e){this.$router.push({name:"Video",params:{video_id:e.toString()}})}}});p.render=c;t["default"]=p},"3bbd":function(e,t,n){},5994:function(e,t,n){"use strict";n("3bbd")},f9d3:function(e,t,n){"use strict";var a=n("7a23"),r=Object(a["T"])("data-v-51387fea");Object(a["C"])("data-v-51387fea");var c={class:"video-intro"},i={class:"video-title"},o={class:"video-created_at"},d={class:"video-uploader"};Object(a["A"])();var u=r((function(e,t,n,r,u,s){var l=Object(a["G"])("van-image");return Object(a["z"])(),Object(a["g"])("div",{class:"row-wrapper",onClick:t[1]||(t[1]=function(){return e.handleClick.apply(e,arguments)})},[Object(a["j"])(l,{class:"video-cover",fit:"contain",radius:8,src:e.video.cover},null,8,["src"]),Object(a["j"])("div",c,[Object(a["j"])("div",i,Object(a["K"])(e.video.title),1),Object(a["j"])("div",o,Object(a["K"])(e.timeFormat(e.video.created_at)),1),Object(a["j"])("div",d,Object(a["K"])(e.video.uploader),1)])])})),s=(n("4056"),n("44bf")),l=n("f19a"),p=Object(a["k"])({name:"VideoRow",components:{VanImage:s["a"]},props:{video:{type:Object,required:!0}},setup:function(){var e=Object(l["a"])(),t=e.timeFormat;return{timeFormat:t}},methods:{handleClick:function(e){this.$emit("click",e)}}});n("5994");p.render=u,p.__scopeId="data-v-51387fea";t["a"]=p}}]);