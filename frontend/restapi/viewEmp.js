
function setupTable() {
    const table = document.getElementById('tableEmployee')

    apiFetchAllBookings(table)
}

setupTable()

function propulateActualData(table, emps) {

    for(const emp of emps) {

        const {id, name,email,dob,age,sal,empStatus} = emp

        const updatePageUrl = `./updateEmp.html?id=${id}`
       


        const row = table.insertRow()
        row.insertCell(0).innerHTML = id
        row.insertCell(1).innerHTML = name
        row.insertCell(2).innerHTML = email
        row.insertCell(3).innerHTML = dob
        row.insertCell(4).innerHTML = age
        row.insertCell(5).innerHTML = sal
        row.insertCell(6).innerHTML = empStatus
        row.insertCell(7).innerHTML = `
        <button type="button" class="btn btn-secondary" onclick="window.location='${updatePageUrl}';" data-bs-dismiss="modal">Update</a></button>
         <button type="button" class="btn btn-secondary" onclick='showConfirmDeleteModal(${id})';" data-bs-dismiss="modal">Delete</a></button>`
    }
}

function showConfirmDeleteModal(id) {
    console.log('clicked ' + id)
    const myModalEl = document.getElementById('deleteModal');
    const modal = new bootstrap.Modal(myModalEl)
    modal.show()

    const btDl = document.getElementById('btDl')
    btDl.onclick = () => {
        apiCallDeleteEmp(id, modal)
        
        window.location.reload()
        
    }
}

function apiFetchAllBookings(table) {

   
    axios.get('http://localhost:8080/company/getemployee')
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
        
}

function apiCallDeleteEmp(id, modal) {
    
    const url = `http://localhost:8080/company/delete/${id}`

    axios.delete(url)
        .then(res => res.data) // you converted complete response in to our business reponse
        // .then( data => console.log(data.msg) ) // this line can be written in destructured form as below
        .then( ({ sts, msg, bd }) =>  modal.hide())
        .catch(console.log)
}