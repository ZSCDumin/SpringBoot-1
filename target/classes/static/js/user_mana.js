var addFlags = true;
$(function () {
    $('#dg')
        .datagrid(
            {
                title: '用户列表',
                url: '/law_consult/user/all',
                fitColumns: true, /* 自适应宽度 */
                striped: true, /* 斑马线效果 */
                pagination: true, /* 底部显示分页工具栏 */
                singleSelect: false, /* 只允许选择一行 */
                rownumbers: true, /* 显示一个行号列 */
                ctrlSelect: true, /* 允许使用Ctrl键+鼠标点击的方式进行多选操作 */
                iconCls: 'icon-ok',
                checkOnSelect: true, /* 点击行的时候该复选框就会被选中或取消选中 */
                selectOnCheck: true, /* 单击复选框将永远选择行 */
                nowrap: true,
                collapsible: true,//是否可折叠的
                pageSize: 5,//每页显示的记录条数，默认为10 
                pageList: [2, 4, 5],//可以设置每页记录条数的列表 
                toolbar: [
                    {
                        text: '查询',
                        iconCls: 'icon-search',
                        handler: function () {
                            $('#dg').datagrid('reload');
                        }
                    },
                    '-',
                    {
                        text: '修改',
                        iconCls: 'icon-edit',
                        handler: function () {
                            alert("点击编辑按钮");
                        }
                    },
                    '-',
                    {
                        text: '添加',
                        iconCls: 'icon-add',
                        handler: function () {
                            if (addFlags) {
                                $('#dg').datagrid('insertRow', {
                                    index: 0,  // 索引从0开始
                                    row: {}
                                });
                                var editIndex = 0;
                                $('#dg').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
                                addFlags = false;
                            }
                        }
                    },
                    '-',
                    {
                        text: '删除',
                        iconCls: 'icon-remove',
                        handler: function () {
                            $.messager.confirm("信息确认", "确定删除吗?",
                                function (ret) {
                                    if (ret) {
                                        var row = $("#dg").datagrid("getSelected");
                                        dbDelete(row)
                                    }
                                });
                        }
                    }],
                columns: [[
                    {
                        field: 'ck',
                        checkbox: true,
                        width: 50,
                    },
                    {
                        field: 'id',
                        hidden: true,
                    },
                    {
                        field: 'account',
                        title: '账号',
                        align: 'center',
                        editor: 'text',
                        width: 100
                    },
                    {
                        field: 'password',
                        title: '密码',
                        width: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'name',
                        title: '姓名',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'age',
                        title: '年龄',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'sex',
                        title: '性别',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'phone',
                        title: '电话',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'email',
                        title: '邮箱',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'certificateNumber',
                        title: '执业证号',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'lawFirm',
                        title: '职业律所',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'address',
                        title: '地址',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'role',
                        title: '角色',
                        width: 100,
                        height: 100,
                        editor: 'text',
                        align: 'center'
                    },
                    {
                        field: 'option',
                        title: '操作',
                        width: 100,
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (row.editing) {
                                var s = '<a href="javascript:void(0);" rel="external nofollow" rel="external nofollow" style="text-decoration:none" onclick="saverow('
                                    + index + ')">保存</a>' + ' '
                                    + '<a href = "javascript:void(0);" style="text-decoration:none" onclick="canclerow('
                                    + index + ')">取消</a>';
                                return s;
                            } else {
                                var e = '<a href="javascript:void(0);" rel="external nofollow" rel="external nofollow" style="text-decoration:none" onclick="editrow('
                                    + index + ')">编辑</a>';
                                return e;
                            }
                        }
                    }]],
                onBeforeEdit: function (index, row) {
                    row.editing = true;
                    $("#dg").datagrid("refreshRow", index);
                },
                onAfterEdit: function (index, row) {
                    row.editing = false;
                    $("#dg").datagrid("refreshRow", index);
                }
            });
    //设置分页控件 
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页  共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录  共 {total} 条记录'
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
    if (addFlags) {
        console.log("1111111");
        dbSave(row);
    } else {
        dbAdd(row);
    }
    addFlags = true;
}

function canclerow(index) {
    $("#dg").datagrid("rejectChanges");
    $("#dg").datagrid('reload');
    addFlags = true;
}

function dbSave(row) {
    var id = row.id;
    var account = row.account;
    var password = row.password;
    var name = row.name;
    var age = row.age;
    var sex = row.sex;
    var phone = row.phone;
    var email = row.email;
    var certificateNumber = row.certificateNumber;
    var lawFirm = row.lawFirm;
    var address = row.address;
    var role = row.role;
    console.log(id + account + password + name + age + sex + phone + email + certificateNumber + lawFirm + address + role);
    $.ajax({
        type: "post",
        url: "/law_consult/user/update",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            id: id,
            account: account,
            password: password,
            name: name,
            age: age,
            sex: sex,
            phone: phone,
            email: email,
            certificateNumber: certificateNumber,
            lawFirm: lawFirm,
            address: address,
            role: role
        }),
        dataType: "json",
        success: function (data) {
            if (data === 1) {
                alert("修改成功");
            } else {
                alert("修改失败");
            }
        },error:function(error){
            console.log(error);
        }
    });
}

function dbDelete(row) {
    if (row.length === 0) {
        $.messager.alert("提示:", "请选择删除的数据");
        return;
    }
    var id = row.id;
    $.post("/law_consult/user/delete", {
        id: id
    }, function (data) {
        if (data === 1) {
            $('#dg').datagrid('reload');
            alert("删除成功");
        } else {
            alert("删除失败");
        }
    });
}

function dbAdd(row) {
    var account = row.account;
    var password = row.password;
    var name = row.name;
    var age = row.age;
    var sex = row.sex;
    var phone = row.phone;
    var email = row.email;
    var certificateNumber = row.certificateNumber;
    var lawFirm = row.lawFirm;
    var address = row.address;
    var role = row.role;
    $.ajax({
        type: "post",
        url: "/law_consult/user/add",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            account: account,
            password: password,
            name: name,
            age: age,
            sex: sex,
            phone: phone,
            email: email,
            certificateNumber: certificateNumber,
            lawFirm: lawFirm,
            address: address,
            role: role
        }),
        dataType: "json",
        success: function (data) {
            if (data === 1) {
                alert("添加成功");
            } else {
                alert("添加失败");
            }
        },error:function(error){
            console.log(error);
        }
    });
}