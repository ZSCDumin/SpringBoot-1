var addFlags = true;
$(function() {
    $('#dg')
        .datagrid(
            {
                title : '用户列表',
                url : '/show',
                fitColumns : true,/* 自适应宽度 */
                striped : true,/* 斑马线效果 */
                pagination : true,/* 底部显示分页工具栏 */
                singleSelect : false,/* 只允许选择一行 */
                rownumbers : true,/* 显示一个行号列 */
                ctrlSelect : true,/* 允许使用Ctrl键+鼠标点击的方式进行多选操作 */
                iconCls : 'icon-ok',
                checkOnSelect : true,/* 点击行的时候该复选框就会被选中或取消选中 */
                selectOnCheck : true,/* 单击复选框将永远选择行 */
                pagination : true,
                nowrap : true,
                rownumbers : true,
                collapsible : true,//是否可折叠的
                pageSize : 5,//每页显示的记录条数，默认为10 
                pageList : [ 2, 4 ,5],//可以设置每页记录条数的列表 
                toolbar : [
                    {
                        text : '查询',
                        iconCls : 'icon-search',
                        handler : function() {
                            $('#dg').datagrid('reload');
                        }
                    },
                    '-',
                    {
                        text : '修改',
                        iconCls : 'icon-edit',
                        handler : function() {
                           alert("点击编辑按钮");
                        }
                    },
                    '-',
                    {
                        text : '添加',
                        iconCls : 'icon-add',
                        handler : function() {
                            if(addFlags){
                                $('#dg').datagrid('insertRow',{
                                    index: 0,  // 索引从0开始
                                    row: {}
                                });
                                var editIndex = 0;
                                $('#dg').datagrid('selectRow',editIndex).datagrid('beginEdit',editIndex);
                                addFlags = false;
                            }
                        }
                    },
                    '-',
                    { text : '删除',
                        iconCls : 'icon-remove',
                        handler : function() {
                            $.messager.confirm("信息确认","确定删除吗?",
                                function(ret) {
                                    if (ret) {
                                        var row = $("#dg").datagrid("getSelected");
                                        dbDelete(row)
                                    }
                                });
                        }
                    } ],
                columns : [ [
                    {
                        field : 'ck',
                        checkbox : true,
                        width : 50,
                    },
                    {
                        field : 'id',
                        hidden : true,
                    },
                    {
                        field : 'name',
                        title : '用户名',
                        align : 'center',
                        editor : 'text',
                        width : 100
                    },
                    {
                        field : 'age',
                        title : '年龄',
                        width : 100,
                        editor : 'text',
                        align : 'center'
                    },
                    {
                        field : 'address',
                        title : '地址',
                        width : 100,
                        height : 100,
                        editor : 'text',
                        align : 'center'
                    },
                    {
                        field : 'school',
                        title : '学校',
                        width : 100,
                        height : 100,
                        editor : 'text',
                        align : 'center'
                    },
                    {
                        field : 'studentID',
                        title : '学号',
                        width : 100,
                        height : 100,
                        editor : 'text',
                        align : 'center'
                    },
                    {
                        field : 'option',
                        title : '操作',
                        width : 100,
                        align : 'center',
                        formatter : function(value, row, index) {
                            if (row.editing) {
                                var s = '<a href="javascript:void(0);" rel="external nofollow" rel="external nofollow" style="text-decoration:none" onclick="saverow('
                                    + index + ')">保存</a>'+' '
                                    +'<a href = "javascript:void(0);" style="text-decoration:none" onclick="canclerow('
                                    + index + ')">取消</a>';
                                return s;
                            } else {
                                var e = '<a href="javascript:void(0);" rel="external nofollow" rel="external nofollow" style="text-decoration:none" onclick="editrow('
                                    + index + ')">编辑</a>';
                                return e;
                            }
                        }
                    } ] ],
                onBeforeEdit : function(index, row) {
                    row.editing = true;
                    $("#dg").datagrid("refreshRow", index);
                },
                onAfterEdit : function(index, row) {
                    row.editing = false;
                    $("#dg").datagrid("refreshRow", index);
                }
            });
    //设置分页控件 
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
        beforePageText : '第',//页数文本框前显示的汉字 
        afterPageText : '页  共 {pages} 页',
        displayMsg : '当前显示 {from} - {to} 条记录  共 {total} 条记录'
    });
});
function editrow(index) {
    var row = $("#dg").datagrid("getSelected");
    if (row == null) {
        alert("请选择您要编辑的行");
        return;
    }
    $("#dg").datagrid("beginEdit", index);
}
function saverow(index) {
    $("#dg").datagrid("endEdit", index);
    var row = $("#dg").datagrid("getSelected");
    if(addFlags) {
        dbSave(row);
    } else {
        dbAdd(row);
    }
    addFlags = true;
}
function canclerow(index) {
    $("#dg").datagrid("rejectChanges");
    $('#dg').datagrid('reload');
    addFlags = true;
}
function dbSave(row) {
    var id =row.id;
    var name = row.name;
    var age = row.age;
    var address = row.address;
    var school = row.school;
    var studentID=row.studentID;
    $.post("/update", {
        ID:id,
        name:name,
        age:age,
        address:address,
        school:school,
        studentID:studentID
    }, function(data) {
        if (data == 1) {
            alert("修改成功");
        } else {
            alert("修改失败");
        }
    });
    alert(row.name + "-" + row.age + "-" + row.address+ "-" +row.school+ "-" +row.studentID);
}
function dbDelete(row) {
    if (row.length == 0) {
        $.messager.alert("提示:","请选择删除的数据");
        return;
    }
    var id =row.id;
    $.post("/delete", {
        ID:id
    }, function(data) {
        if (data > 0) {
            $('#dg').datagrid('reload');
            alert("删除成功");
        } else {
            alert("删除失败");
        }
    });
    alert(row.name + "-" + row.age + "-" + row.address+ "-" +row.school+ "-" +row.studentID);
}
function dbAdd(row) {
    var name = row.name;
    var age = row.age;
    var address = row.address;
    var school = row.school;
    var studentID=row.studentID;
    $.post("/add", {
        name:name,
        age:age,
        address:address,
        school:school,
        studentID:studentID
    }, function(count) {
        if (count == 1) {
            alert("添加成功");
        } else {
            alert("添加失败");
        }
    });
    alert(row.name + "-" + row.age + "-" + row.address+ "-" +row.school+ "-" +row.studentID);
}