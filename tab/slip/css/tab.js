function $(id){
    return typeof id=='string'?document.getElementById(id):id;
}

window.onload=function(){
    //获取鼠标滑过或点击的标签和要切换的内容的元素
    var titles=$('notice-title').getElementsByTagName("li");
    var divs=$('notice-content').getElementsByTagName('div');
 //   alert(titles.length);
    if(titles.length!=divs.length)
        return;
    //遍历titles下的所有li
    for(var i=0;i<titles.length;i++){
        titles[i].id=i;
        //绑定鼠标滑过时间
        titles[i].onmouseover=function(){
            //在标签绑定时间之前，先将其他标签的样式还原
            for(var j=0;j<titles.length;j++){
              titles[j].className='';
              divs[j].style.display="none";
            }
            //设置当前为高亮显示
            this.className='select';
            divs[this.id].style.display="block";

        }
    }
}