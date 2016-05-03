function tipShow(idName){

	var idObj = $(idName);
	var idBgObj = $("#bgWindow");

	if(idBgObj.length == 0){
		var iframe,div;
		div = $("<div></div>");
		div.attr({id:"bgWindow",style:"display:none"});
		iframe = $("<iframe></iframe>");
		iframe.attr({id:"bgWindowIframe",src:"about:blank",marginwidth:"0",marginheight:"0",frameBorder:"no",framespacing:"0",allowtransparency:"true"});
		div.append(iframe);
		$(document.body).append(div);
		idBgObj = $("#bgWindow");	
	}

	var winH = $(window).height();
	var docH = $(document.body).height();
	if(winH > docH){docH = winH;}
	
	var winW = $(window).width();
	var docW = $(document.body).width();
	if(winW > docW){docW = winW;}

	var scrollH = $(document).scrollTop();
	if(scrollH == undefined){scrollH = 0}
	//alert(idObj.height());
	var t = parseInt((winH - idObj.height())/2);
	if(idObj.css("position") == "absolute"){t = t + scrollH;}
	if(t != parseInt(idObj.css("top"))){idObj.css("top",t);}

	var l = parseInt((winW - idObj.width())/2);
	if(l < 0){l = 0;}
	if(l != parseInt(idObj.css("left"))){idObj.css("left",l);}
	
	if(docW != parseInt(idBgObj.css("width"))){idBgObj.css("width",docW);}
	if(docH != parseInt(idBgObj.css("height"))){idBgObj.css("height",docH);idBgObj.find("iframe").css("height",docH);}

	idBgObj.show();
	idObj.show();

	window.onresize = function(){
		if(idObj.css("display") == "block"){tipShow(idName);}
	};
	window.onscroll = function(){
		if(idObj.css("display") == "block"){tipShow(idName);}
	};
	
	var close = idName + "Close";
	var reset = idName + "Reset";
	var ok = idName + "Ok";
	if($(close).length == 1){$(close).click(function(){tipHide(idName);});}
	if($(reset).length == 1){$(reset).click(function(){tipHide(idName);});}
	if($(ok).length == 1){$(ok).click(function(){tipHide(idName);});}
}

function tipHide(idName){$(idName).hide();$("#bgWindow").hide();}

/*设为首页*/
function setHomePage(obj){var aUrls=document.URL.split("/");var vDomainName="http://"+aUrls[2]+"/";try{/*IE*/obj.style.behavior="url(#default#homepage)";obj.setHomePage(vDomainName);}catch(e){/*other*/if(window.netscape) {/*ff*/try {netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); } catch (e) { alert("抱歉！您的浏览器不支持直接设为首页。请在浏览器地址栏输入\"about:config\"并回车然后将[signed.applets.codebase_principal_support]设置为\"true\"，点击\"加入收藏\"后忽略安全提示，即可设置成功。"); }var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);prefs.setCharPref('browser.startup.homepage',vDomainName);}}if(window.netscape)alert("抱歉！您的浏览器不支持直接设为首页。请在浏览器地址栏输入\"about:config\"并回车然后将[signed.applets.codebase_principal_support]设置为\"true\"，点击\"加入收藏\"后忽略安全提示，即可设置成功。");}
/*定时跳转*/
function countDown(idn,second,url){$(idn).text(second);if(--second>0){setTimeout("countDown('"+idn+"',"+second+",'"+url+"')",1000);}else{location.href=url;}}
/*定时隐藏*/
function countHide(idn,second){if(--second>0){setTimeout("countHide('"+idn+"',"+second+")",1000);}else{$(idn).fadeOut('slow');}}
/*幻灯片*/
(function(a){a.flexslider=function(c,b){var d=c;d.init=function(){d.vars=a.extend({},a.flexslider.defaults,b);d.data("flexslider",true);d.container=a(".slides",d);d.slides=a(".slides > li",d);d.count=d.slides.length;d.animating=false;d.currentSlide=d.vars.slideToStart;d.animatingTo=d.currentSlide;d.atEnd=(d.currentSlide==0)?true:false;d.eventType=("ontouchstart" in document.documentElement)?"touchstart":"click";d.cloneCount=0;d.cloneOffset=0;if(d.vars.controlsContainer!=""){d.controlsContainer=a(d.vars.controlsContainer).eq(a(".slides").index(d.container));d.containerExists=d.controlsContainer.length>0}if(d.vars.manualControls!=""){d.manualControls=a(d.vars.manualControls,((d.containerExists)?d.controlsContainer:d));d.manualExists=d.manualControls.length>0}if(d.vars.randomize){d.slides.sort(function(){return(Math.round(Math.random())-0.5)});d.container.empty().append(d.slides)}if(d.vars.animation.toLowerCase()=="slide"){d.css({overflow:"hidden"});if(d.vars.animationLoop){d.cloneCount=2;d.cloneOffset=1;d.container.append(d.slides.filter(":first").clone().addClass("clone")).prepend(d.slides.filter(":last").clone().addClass("clone"))}d.container.width(((d.count+d.cloneCount)*d.width())+2000);d.newSlides=a(".slides > li",d);setTimeout(function(){d.newSlides.width(d.width()).css({"float":"left"}).show()},100);d.container.css({marginLeft:(-1*(d.currentSlide+d.cloneOffset))*d.width()+"px"})}else{d.slides.css({width:"100%","float":"left",marginRight:"-100%"}).eq(d.currentSlide).fadeIn(400)}if(d.vars.controlNav){if(d.manualExists){d.controlNav=d.manualControls}else{var g=a('<ol class="flex-control-nav"></ol>');var k=1;for(var l=0;l<d.count;l++){g.append("<li><a>"+k+"</a></li>");k++}if(d.containerExists){a(d.controlsContainer).append(g);d.controlNav=a(".flex-control-nav li a",d.controlsContainer)}else{d.append(g);d.controlNav=a(".flex-control-nav li a",d)}}d.controlNav.eq(d.currentSlide).addClass("active");d.controlNav.bind(d.eventType,function(i){i.preventDefault();if(!a(this).hasClass("active")){d.flexAnimate(d.controlNav.index(a(this)),d.vars.pauseOnAction)}})}if(d.vars.directionNav){var f=a('<ul class="flex-direction-nav"><li><a class="prev" href="#">'+d.vars.prevText+'</a></li><li><a class="next" href="#">'+d.vars.nextText+"</a></li></ul>");if(d.containerExists){a(d.controlsContainer).append(f);d.directionNav=a(".flex-direction-nav li a",d.controlsContainer)}else{d.append(f);d.directionNav=a(".flex-direction-nav li a",d)}if(!d.vars.animationLoop){if(d.currentSlide==0){d.directionNav.filter(".prev").addClass("disabled")}else{if(d.currentSlide==d.count-1){d.directionNav.filter(".next").addClass("disabled")}}}d.directionNav.bind(d.eventType,function(i){i.preventDefault();var j=(a(this).hasClass("next"))?d.getTarget("next"):d.getTarget("prev");if(d.canAdvance(j)){d.flexAnimate(j,d.vars.pauseOnAction)}})}if(d.vars.keyboardNav&&a("ul.slides").length==1){a(document).keyup(function(i){if(d.animating){return}else{if(i.keyCode!=39&&i.keyCode!=37){return}else{if(i.keyCode==39){var j=d.getTarget("next")}else{if(i.keyCode==37){var j=d.getTarget("prev")}}if(d.canAdvance(j)){d.flexAnimate(j,d.vars.pauseOnAction)}}}})}if(d.vars.slideshow){if(d.vars.pauseOnHover&&d.vars.slideshow){d.hover(function(){d.pause()},function(){d.resume()})}d.animatedSlides=setInterval(d.animateSlides,d.vars.slideshowSpeed)}if(d.vars.pausePlay){var e=a('<div class="flex-pauseplay"><span></span></div>');if(d.containerExists){d.controlsContainer.append(e);d.pausePlay=a(".flex-pauseplay span",d.controlsContainer)}else{d.append(e);d.pausePlay=a(".flex-pauseplay span",d)}var h=(d.vars.slideshow)?"pause":"play";d.pausePlay.addClass(h).text(h);d.pausePlay.click(function(i){i.preventDefault();(a(this).hasClass("pause"))?d.pause():d.resume()})}if(d.vars.touchSwipe&&"ontouchstart" in document.documentElement){d.each(function(){var i,j=20;isMoving=false;function o(){this.removeEventListener("touchmove",m);i=null;isMoving=false}function m(s){if(isMoving){var p=s.touches[0].pageX,q=i-p;if(Math.abs(q)>=j){o();var r=(q>0)?d.getTarget("next"):d.getTarget("prev");if(d.canAdvance(r)){d.flexAnimate(r,d.vars.pauseOnAction)}}}}function n(p){if(p.touches.length==1){i=p.touches[0].pageX;isMoving=true;this.addEventListener("touchmove",m,false)}}if("ontouchstart" in document.documentElement){this.addEventListener("touchstart",n,false)}})}if(d.vars.animation.toLowerCase()=="slide"){d.sliderTimer;a(window).resize(function(){d.newSlides.width(d.width());d.container.width(((d.count+d.cloneCount)*d.width())+2000);clearTimeout(d.sliderTimer);d.sliderTimer=setTimeout(function(){d.flexAnimate(d.currentSlide)},300)})}d.vars.start(d)};d.flexAnimate=function(f,e){if(!d.animating){d.animating=true;if(e){d.pause()}if(d.vars.controlNav){d.controlNav.removeClass("active").eq(f).addClass("active")}d.atEnd=(f==0||f==d.count-1)?true:false;if(!d.vars.animationLoop){if(f==0){d.directionNav.removeClass("disabled").filter(".prev").addClass("disabled")}else{if(f==d.count-1){d.directionNav.removeClass("disabled").filter(".next").addClass("disabled");d.pause();d.vars.end(d)}else{d.directionNav.removeClass("disabled")}}}d.animatingTo=f;d.vars.before(d);if(d.vars.animation.toLowerCase()=="slide"){if(d.currentSlide==0&&f==d.count-1&&d.vars.animationLoop){d.slideString="0px"}else{if(d.currentSlide==d.count-1&&f==0&&d.vars.animationLoop){d.slideString=(-1*(d.count+1))*d.slides.filter(":first").width()+"px"}else{d.slideString=(-1*(f+d.cloneOffset))*d.slides.filter(":first").width()+"px"}}d.container.animate({marginLeft:d.slideString},d.vars.animationDuration,function(){if(d.currentSlide==0&&f==d.count-1&&d.vars.animationLoop){d.container.css({marginLeft:(-1*d.count)*d.slides.filter(":first").width()+"px"})}else{if(d.currentSlide==d.count-1&&f==0&&d.vars.animationLoop){d.container.css({marginLeft:-1*d.slides.filter(":first").width()+"px"})}}d.animating=false;d.currentSlide=f;d.vars.after(d)})}else{d.slides.eq(d.currentSlide).fadeOut(d.vars.animationDuration);d.slides.eq(f).fadeIn(d.vars.animationDuration,function(){d.animating=false;d.currentSlide=f;d.vars.after(d)})}}};d.animateSlides=function(){if(!d.animating){var e=(d.currentSlide==d.count-1)?0:d.currentSlide+1;d.flexAnimate(e)}};d.pause=function(){clearInterval(d.animatedSlides);if(d.vars.pausePlay){d.pausePlay.removeClass("pause").addClass("play").text("play")}};d.resume=function(){d.animatedSlides=setInterval(d.animateSlides,d.vars.slideshowSpeed);if(d.vars.pausePlay){d.pausePlay.removeClass("play").addClass("pause").text("pause")}};d.canAdvance=function(e){if(!d.vars.animationLoop&&d.atEnd){if(d.currentSlide==0&&e==d.count-1&&d.direction!="next"){return false}else{if(d.currentSlide==d.count-1&&e==0&&d.direction=="next"){return false}else{return true}}}else{return true}};d.getTarget=function(e){d.direction=e;if(e=="next"){return(d.currentSlide==d.count-1)?0:d.currentSlide+1}else{return(d.currentSlide==0)?d.count-1:d.currentSlide-1}};d.init()};a.flexslider.defaults={animation:"fade",slideshow:true,slideshowSpeed:7000,animationDuration:600,directionNav:true,controlNav:true,keyboardNav:true,touchSwipe:true,prevText:"Previous",nextText:"Next",pausePlay:false,randomize:false,slideToStart:0,animationLoop:true,pauseOnAction:true,pauseOnHover:false,controlsContainer:"",manualControls:"",start:function(){},before:function(){},after:function(){},end:function(){}};a.fn.flexslider=function(b){return this.each(function(){if(a(this).find(".slides li").length==1){a(this).find(".slides li").fadeIn(400)}else{if(a(this).data("flexslider")!=true){new a.flexslider(a(this),b)}}})}})(jQuery);
/*产品图展示*/
(function($){$(document).ready(function(){$('.cloud-zoom, .cloud-zoom-gallery').CloudZoom()});function format(str){for(var i=1;i<arguments.length;i++){str=str.replace('%'+(i-1),arguments[i])}return str}function CloudZoom(jWin,opts){var sImg=$('img',jWin);var img1;var img2;var zoomDiv=null;var $mouseTrap=null;var lens=null;var $tint=null;var softFocus=null;var $ie6Fix=null;var zoomImage;var controlTimer=0;var cw,ch;var destU=0;var destV=0;var currV=0;var currU=0;var filesLoaded=0;var mx,my;var ctx=this,zw;setTimeout(function(){if($mouseTrap===null){var w=jWin.width();jWin.parent().append(format('<div style="width:%0px;position:absolute;top:75%;left:%1px;text-align:center" class="cloud-zoom-loading" >Loading...</div>',w/3,(w/2)-(w/6))).find(':last').css('opacity',0.5)}},200);var ie6FixRemove=function(){if($ie6Fix!==null){$ie6Fix.remove();$ie6Fix=null}};this.removeBits=function(){if(lens){lens.remove();lens=null}if($tint){$tint.remove();$tint=null}if(softFocus){softFocus.remove();softFocus=null}ie6FixRemove();$('.cloud-zoom-loading',jWin.parent()).remove()};this.destroy=function(){jWin.data('zoom',null);if($mouseTrap){$mouseTrap.unbind();$mouseTrap.remove();$mouseTrap=null}if(zoomDiv){zoomDiv.remove();zoomDiv=null}this.removeBits()};this.fadedOut=function(){if(zoomDiv){zoomDiv.remove();zoomDiv=null}this.removeBits()};this.controlLoop=function(){if(lens){var x=(mx-sImg.offset().left-(cw*0.5))>>0;var y=(my-sImg.offset().top-(ch*0.5))>>0;if(x<0){x=0}else if(x>(sImg.outerWidth()-cw)){x=(sImg.outerWidth()-cw)}if(y<0){y=0}else if(y>(sImg.outerHeight()-ch)){y=(sImg.outerHeight()-ch)}lens.css({left:x,top:y});lens.css('background-position',(-x)+'px '+(-y)+'px');destU=(((x)/sImg.outerWidth())*zoomImage.width)>>0;destV=(((y)/sImg.outerHeight())*zoomImage.height)>>0;currU+=(destU-currU)/opts.smoothMove;currV+=(destV-currV)/opts.smoothMove;zoomDiv.css('background-position',(-(currU>>0)+'px ')+(-(currV>>0)+'px'))}controlTimer=setTimeout(function(){ctx.controlLoop()},30)};this.init2=function(img,id){filesLoaded++;if(id===1){zoomImage=img}if(filesLoaded===2){this.init()}};this.init=function(){$('.cloud-zoom-loading',jWin.parent()).remove();$mouseTrap=jWin.parent().append(format("<div class='mousetrap' style='background-image:url(\".\");z-index:999;position:absolute;width:%0px;height:%1px;left:%2px;top:%3px;\'></div>",sImg.outerWidth(),sImg.outerHeight(),0,0)).find(':last');$mouseTrap.bind('mousemove',this,function(event){mx=event.pageX;my=event.pageY});$mouseTrap.bind('mouseleave',this,function(event){clearTimeout(controlTimer);if(lens){lens.fadeOut(299)}if($tint){$tint.fadeOut(299)}if(softFocus){softFocus.fadeOut(299)}zoomDiv.fadeOut(300,function(){ctx.fadedOut()});return false});$mouseTrap.bind('mouseenter',this,function(event){mx=event.pageX;my=event.pageY;zw=event.data;if(zoomDiv){zoomDiv.stop(true,false);zoomDiv.remove();}var xPos=opts.adjustX,yPos=opts.adjustY;var siw=sImg.outerWidth();var sih=sImg.outerHeight();var w=opts.zoomWidth;var h=opts.zoomHeight;if(opts.zoomWidth=='auto'){w=siw}if(opts.zoomHeight=='auto'){h=sih}var appendTo=jWin.parent();switch(opts.position){case'top':yPos-=h;break;case'right':xPos+=siw;break;case'bottom':yPos+=sih;break;case'left':xPos-=w;break;case'inside':w=siw;h=sih;break;default:appendTo=$('#'+opts.position);if(!appendTo.length){appendTo=jWin;xPos+=siw;yPos+=sih}else{w=appendTo.innerWidth();h=appendTo.innerHeight()}}zoomDiv=appendTo.append(format('<div id="cloud-zoom-big" class="cloud-zoom-big" style="display:none;position:absolute;left:%0px;top:%1px;width:%2px;height:%3px;background-image:url(\'%4\');z-index:99;"></div>',xPos,yPos,w,h,zoomImage.src)).find(':last');if(sImg.attr('title')&&opts.showTitle){zoomDiv.append(format('<div class="cloud-zoom-title">%0</div>',sImg.attr('title'))).find(':last').css('opacity',opts.titleOpacity)}if($.browser.msie&&$.browser.version<7){if(zoomDiv.parent().find('iframe').length>0){return false;}$ie6Fix=$('<iframe frameborder="0" src="#"></iframe>').css({position:"absolute",left:xPos,top:yPos,zIndex:99,width:w,height:h}).insertBefore(zoomDiv)}zoomDiv.fadeIn(500);if(lens){lens.remove();lens=null}cw=(sImg.outerWidth()/zoomImage.width)*zoomDiv.width();ch=(sImg.outerHeight()/zoomImage.height)*zoomDiv.height();lens=jWin.append(format("<div class = 'cloud-zoom-lens' style='display:none;z-index:98;position:absolute;width:%0px;height:%1px;'></div>",cw,ch)).find(':last');$mouseTrap.css('cursor',lens.css('cursor'));var noTrans=false;if(opts.tint){lens.css('background','url("'+sImg.attr('src')+'")');$tint=jWin.append(format('<div style="display:none;position:absolute; left:0px; top:0px; width:%0px; height:%1px; background-color:%2;" />',sImg.outerWidth(),sImg.outerHeight(),opts.tint)).find(':last');$tint.css('opacity',opts.tintOpacity);noTrans=true;$tint.fadeIn(500)}if(opts.softFocus){lens.css('background','url("'+sImg.attr('src')+'")');softFocus=jWin.append(format('<div style="position:absolute;display:none;top:2px; left:2px; width:%0px; height:%1px;" />',sImg.outerWidth()-2,sImg.outerHeight()-2,opts.tint)).find(':last');softFocus.css('background','url("'+sImg.attr('src')+'")');softFocus.css('opacity',0.5);noTrans=true;softFocus.fadeIn(500)}if(!noTrans){lens.css('opacity',opts.lensOpacity)}if(opts.position!=='inside'){lens.fadeIn(500)}zw.controlLoop();return})};img1=new Image();$(img1).load(function(){ctx.init2(this,0)});img1.src=sImg.attr('src');img2=new Image();$(img2).load(function(){ctx.init2(this,1)});img2.src=jWin.attr('href')}$.fn.CloudZoom=function(options){try{document.execCommand("BackgroundImageCache",false,true)}catch(e){}this.each(function(){var relOpts,opts;eval('var	a = {'+$(this).attr('rel')+'}');relOpts=a;if($(this).is('.cloud-zoom')){$(this).css({'position':'relative','display':'block'});$('img',$(this)).css({'display':'block'});if($(this).parent().attr('id')!='wrap'){$(this).wrap('<div id="wrap" style="top:0px;z-index:9999;position:relative;"></div>')}opts=$.extend({},$.fn.CloudZoom.defaults,options);opts=$.extend({},opts,relOpts);$(this).data('zoom',new CloudZoom($(this),opts))}else if($(this).is('.cloud-zoom-gallery')){opts=$.extend({},relOpts,options);$(this).data('relOpts',opts);$(this).bind('click',$(this),function(event){var data=event.data.data('relOpts');$('#'+data.useZoom).data('zoom').destroy();$('#'+data.useZoom).attr('href',event.data.attr('href'));$('#'+data.useZoom+' img').attr('src',event.data.data('relOpts').smallImage);$('#'+event.data.data('relOpts').useZoom).CloudZoom();return false})}});return this};$.fn.CloudZoom.defaults={zoomWidth:'auto',zoomHeight:'auto',position:'right',tint:false,tintOpacity:0.5,lensOpacity:0.5,softFocus:false,smoothMove:3,showTitle:true,titleOpacity:0.5,adjustX:0,adjustY:0}})(jQuery);

$(function(){

	$("#addFavorite").click(function(){addToFavorite();});
	$("#setHome").click(function(){setHomePage(this,window.location);});
	
	$(".adr").click(function(){tipShow('#resTip');});

	$(".sit").hover(function(){
		$(".sit .sel").addClass('here');
		$(".sit ul").show();
	},function(){
		$(".sit ul").hide();
		$(".sit .sel").removeClass('here');
	});

	var idName;
	$(".nav li").hover(function(){
		$(this).addClass('m-hover');
		var len = $(this).find('div').length;
		if(len){
			$(this).find('div').removeClass('hidden');
		}
	},function(){
		$(this).removeClass('m-hover');
		var len = $(this).find('div').length;
		if(len){
			$(this).find('div').addClass('hidden');
		}
	});

	var jQInputUserName = $('#loginUserName');
	var jQUserNameLabel = $('#userNameLabel');

	jQInputUserName.keydown(function(){
		jQUserNameLabel.hide();
	});
	jQInputUserName.focus(function(){
		if($(this).val()==""){
			jQUserNameLabel.show();
			jQUserNameLabel.addClass("gray");
		}
	});
	jQInputUserName.blur(function(){
		if($(this).val()==""){
			jQUserNameLabel.show();
			jQUserNameLabel.removeClass("gray");
		}
	});

	if(jQInputUserName.val()!=""){jQUserNameLabel.hide();}

	$("#cart,.area dl,.goto").hover(function(){
		var dt = $(this).find('dt');
		var dd = $(this).find('dd');
		
		dt.addClass('hover');
		dd.removeClass('hidden');

		var len = $("#cart dd ul").length;
		if(len){
			$("#cart dd ul li").hover(function(){
				$(this).addClass('hover');
			},function(){
				$(this).removeClass('hover');
			});
		}

	},function(){
		$(this).find('dt').removeClass('hover');
		$(this).find('dd').addClass('hidden');
	});

	$(".bg_text").toggle(function(){
		var dt = $(this).find('dt');
		var dd = $(this).find('dd');
		
		dt.addClass('hover');
		dd.removeClass('hidden');

		var cln = $(this).attr('class');
		if(cln == 'bg_text'){
			$(this).find('a').click(function(){
				var txt = $(this).text();
				var rel = $(this).attr('rel');
				dt.text(txt);
				dt.attr('title',txt);
				dd.addClass('hidden');
				if(rel){
					$(this).parent().find('a').each(function(){
						var rel = $(this).attr('rel');
						$(rel).addClass('hidden')
					});
					$(rel).removeClass('hidden')
				};
			});
			$(this).find('em').click(function(){
				$(this).addClass("gray");
				$(this).parent().find('input').focus();
			});
		}

	},function(){
		$(this).find('dt').removeClass('hover');
		$(this).find('dd').addClass('hidden');
	});

	$(".h2_ch,.h3_ch,.h3_ch2,.h4_ch,.em_ch").each(function(i, items_list){
		$(items_list).find('a').mouseover(function(){
			$(items_list).find('a').each(function(j, li){
				$(li).removeClass('here');
				$($(li).attr("rel")).hide();
			});
			$(this).addClass('here');
			$($(this).attr("rel")).show();
		});
	});

	$(".h2_ch1,.h2_ch2").each(function(i, items_list){
		$(items_list).find('a').click(function(){
			$(items_list).find('a').each(function(j, li){
				$(li).removeClass('here');
				$($(li).attr("rel")).hide();
			});
			$(this).addClass('here');
			$($(this).attr("rel")).show();
		});
	});

});