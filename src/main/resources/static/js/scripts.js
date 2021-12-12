const myModal = document.getElementById('myModal');
const myInput = document.getElementById('myInput');
const table = document.getElementById("refresh");
const ModalLabel = document.getElementById("ModalLabel");

myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus()
})

function remove(Id) {
    if (confirm('Are you sure you want to delete')) {
        window.location.href = window.location.href + '/' + Id;
    }
}

function reset() {
    document.getElementById("form").reset();
    ModalLabel.innerText = ModalLabel.innerText.replace("Edit","New");
}

function edit(index, Title) {
    ModalLabel.innerText =  ModalLabel.innerText.replace("New","Edit");
    const nb = parseInt(index) + 1;
    if (Title === 'Universities') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("name").value = table.rows[nb].cells.item(1).innerHTML;
        document.getElementById("website").value = table.rows[nb].cells.item(2).innerHTML;
    } else if (Title === 'Departments') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("name").value = table.rows[nb].cells.item(1).innerHTML;
        let university = table.rows[nb].cells.item(3).innerHTML;
        Array.from(document.querySelector("#select").options).forEach(function(option_element) {

            if (option_element.text === university) {
                option_element.selected = true;
            }

        });
    } else if (Title === 'Instructors') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("firstname").value = table.rows[nb].cells.item(1).innerHTML;
        document.getElementById("lastname").value = table.rows[nb].cells.item(2).innerHTML;
        document.getElementById("diploma").value = table.rows[nb].cells.item(3).innerHTML;
        document.getElementById("email").value = table.rows[nb].cells.item(4).innerHTML;
        document.getElementById("phone").value = table.rows[nb].cells.item(5).innerHTML;
        document.getElementById("adress").value = table.rows[nb].cells.item(8).innerHTML;
        let department = table.rows[nb].cells.item(6).innerHTML;
        Array.from(document.querySelector("#select").options).forEach(function(option_element) {

            if (option_element.text === department) {
                option_element.selected = true;
            }

        });
    } else if (Title === 'Classrooms') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("name").value = table.rows[nb].cells.item(1).innerHTML;
        document.getElementById("capacity").value = table.rows[nb].cells.item(3).innerHTML;
        let classroom = table.rows[nb].cells.item(2).innerHTML;
        Array.from(document.querySelector("#select").options).forEach(function(option_element) {

            if (option_element.text === classroom) {
                option_element.selected = true;
            }

        });
    } else if (Title === 'Courses') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("name").value = table.rows[nb].cells.item(1).innerHTML;
        document.getElementById("coef").value = table.rows[nb].cells.item(2).innerHTML;
    } else if (Title === 'Groups') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("name").value = table.rows[nb].cells.item(1).innerHTML;
    } else if (Title === 'Sessions') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("date").value = formatDate(new Date(table.rows[nb].cells.item(1).innerHTML));
        document.getElementById("time").value = table.rows[nb].cells.item(2).innerHTML;

        let instructor = table.rows[nb].cells.item(3).innerHTML;
        Array.from(document.querySelector("#instructor").options).forEach(function(option_element) {

            if (option_element.text === instructor) {
                option_element.selected = true;
            }

        });
        let classroom = table.rows[nb].cells.item(4).innerHTML;
        Array.from(document.querySelector("#classroom").options).forEach(function(option_element) {

            if (option_element.text === classroom) {
                option_element.selected = true;
            }

        });
        let course = table.rows[nb].cells.item(5).innerHTML;
        Array.from(document.querySelector("#course").options).forEach(function(option_element) {

            if (option_element.text === course) {
                option_element.selected = true;
            }

        });
        let group = table.rows[nb].cells.item(6).innerHTML;
        Array.from(document.querySelector("#group").options).forEach(function(option_element) {

            if (option_element.text === group) {
                option_element.selected = true;
            }

        });
    } else if (Title === 'Students') {
        document.getElementById("code").value = table.rows[nb].cells.item(0).innerHTML;
        document.getElementById("firstname").value = table.rows[nb].cells.item(2).innerHTML;
        document.getElementById("lastname").value = table.rows[nb].cells.item(3).innerHTML;
        document.getElementById("email").value = table.rows[nb].cells.item(4).innerHTML;
        document.getElementById("phone").value = table.rows[nb].cells.item(5).innerHTML;
        document.getElementById("birthdate").value = formatDate(new Date(table.rows[nb].cells.item(6).innerHTML));
        document.getElementById("adress").value = table.rows[nb].cells.item(7).innerHTML;
        document.getElementById("date").value = formatDate(new Date(table.rows[nb].cells.item(8).innerHTML));
        let group = table.rows[nb].cells.item(1).innerHTML;
        Array.from(document.querySelector("#group").options).forEach(function(option_element) {

            if (option_element.text === group) {
                option_element.selected = true;
            }

        });
    }
}

function refreshTable()
{
    $("#refresh").load(window.location.href + " #refresh" );
}

function formatDate(date) {
    let d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}