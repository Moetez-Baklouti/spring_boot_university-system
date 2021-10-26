var myModal = document.getElementById('myModal')
var myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus()
})

function refreshTable()
{
    $( "#refresh" ).load(window.location.href + " #refresh" );
}

function goTo(page, title, url) {
    if ("undefined" !== typeof history.pushState) {
        history.pushState({page: page}, title, url);
    } else {
        window.location.assign(url);
    }
}
function dep() {
    goTo("/departments", "example", '/departments');
}