

const validateForm = ({ name, email, password }) => {

    if (name.length <= 2) return { msg: 'invalid Name', sts: false}
    if (email.length <= 3) return { msg: 'invalid email', sts: false}
    if (!email.includes(".com")) return { msg: 'invalid email', sts: false}

    return { sts : 'success', msg :'all fields are valid' }
}

function createNewUser(user, form)
{
    const headers = {
        'content-type' : 'application/json'
    }


    axios.post('http://localhost:8080/company/createEmp', user, { headers })
         .then(res => {

            form.reset()
            showSuccessModal()
         })

         .catch(err => console.log(err))
}

function setupForm()
{
    const err = document.getElementById('errMsg')
    err.style.display = 'none'

    const formCreateUser= document.getElementById('formCreateUser')

    formCreateUser.onsubmit = ev => {
        ev.preventDefault()
        console.log(ev)

        // this is used for insert the data manully dynamic 
        const formData = new FormData(ev.target)

        for(let key of formData.keys())
        {
            console.log(key)
        }

        for(let val of formData.values())
        {
            console.log(val)
        }

        const user = Object.fromEntries(formData.entries())
        console.log(user)

        const { sts, msg } = validateForm(user)

        if (sts) createNewUser(user, formCreateUser)
        else {
            err.style.display = 'block'
            err.innerHTML = `<strong>${msg}</strong>`
        }

        
    }
}

setupForm()

function showSuccessModal() {
    const myModalEl = document.getElementById('successModal');
    const modal = new bootstrap.Modal(myModalEl)
    modal.show()
}