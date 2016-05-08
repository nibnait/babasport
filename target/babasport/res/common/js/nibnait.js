/**
 * Created by uu789 on 2016/5/8.
 */


/**
 *checkNumber
 * @param theObj
 * @returns {boolean}
 */
function checkNumber(theObj)
{
    if(typeof(theObj.value)!="undefined"&&theObj.value!=""&&!isNaN(theObj.value))
    {
        return true;
    }
    return false;
}

/**
 * 去空格
 * @param str
 * @returns {string|*}
 * @constructor
 */
function LTrim(str)
{
    var i;
    for(i=0;i<str.length;i++)
    {
        if(str.charAt(i)!=" "&&str.charAt(i)!=" ")break;
    }
    str=str.substring(i,str.length);
    return str;
}

function RTrim(str)
{
    var i;
    for(i=str.length-1;i>=0;i--)
    {
        if(str.charAt(i)!=" "&&str.charAt(i)!="?")break;
    }
    str=str.substring(0,i+1);
    return str;
}

function Trim(str)
{
    return LTrim(RTrim(str));
}

/**
 * 全选
 * @param brandHead
 */
function checkBox(brandHead){
    $("input[type=checkbox][name=ids]").attr("checked",brandHead.checked);
}

//表头的checkBox联动
function checkHead() {
    var s = $("input[name='ids']:checked").size();
    var pageSize = $("input[name='ids']").size();
    if(s < pageSize){
        $('input[type=checkbox][name=brandhead]').attr('checked', false);
    }else if (s===pageSize){
        $('input[type=checkbox][name=brandhead]').attr('checked', true);
    }
}




