/*
* 批量删除
* */
function deleteBatch() {
    $("#mainForm").attr("action","/DelectBatchServlet");
    $("#MAINFORM").submit();
}