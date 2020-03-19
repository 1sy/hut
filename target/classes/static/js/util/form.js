function post(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in PARAMS) {
        var opt = document.createElement("textarea");
        opt.name = x;
        opt.value = PARAMS[x];
        // alert(opt.name)
        temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}
// 调用方法 如：
// 代码如下:
//     post('pages/statisticsJsp/excel.action',{html:prnhtml,cm1:'sdsddsd',cm2:'haha'});