const path = '/DunderDemo'
const getallbut = document.getElementById("get-all-button")
const getoneform = document.getElementById("get-one-form")
const deleteForm = document.getElementById("delete-form")
const insertForm = document.getElementById("insert-form")
const updateForm = document.getElementById("update-form")
const objectHolder = document.getElementById("object-holder")

function clearAllEl(el) {
    while(el.firstElementChild) {
        el.removeChild(el.lastElementChild);
    }
}

function createP(text, label) {
    let pEl = document.createElement("p")
    pEl.textContent = `${label}: ${text}`
    return pEl
}

function createObjectEl(obj) {
    let objectEl = document.createElement("div")
    let elHeader = document.createElement("h4")
    let elBody = document.createElement("div")
    objectEl.classList.add("object-element")
    elHeader.classList.add("object-header")
    elBody.classList.add("object-body")
    elHeader.textContent = `${obj.id}: ${obj.name}`
    elBody.appendChild(createP(obj.email, "Email"))
    elBody.appendChild(createP(obj.balance, "Balance"))
    elBody.appendChild(createP(obj.isActive, "Active Status"))
    elBody.appendChild(createP(obj.secondsSince, "Seconds Since Creation"))
    objectEl.appendChild(elHeader)
    objectEl.appendChild(elBody)
    objectEl.addEventListener('click', () => {
        updateForm.classList.remove("hide")
        updateForm.style.animation = "fadescalein 350ms ease-in"
        updateForm.id.value = obj.id
        updateForm.name.value = obj.name
        updateForm.email.value = obj.email
        updateForm.balance.value = obj.balance
        updateForm.isActive.value = obj.isActive
        updateForm.secondsSince.value = obj.secondsSince
    })
    return objectEl
}

getallbut.addEventListener('click', () => {
    fetch(path + '/getall', {
        method: "GET"
    }).then((res) => {
        return res.json();
    }).then((data) => {
        if(!data) {
            return;
        }
        clearAllEl(objectHolder)
        for(let d of data) {
            objectHolder.appendChild(createObjectEl(d))
        }
    })
})

getoneform.addEventListener('submit', (e) => {
    e.preventDefault();
    fetch(path + '/getone?id=' + getoneform.idinput.value, {
        method: "GET"
    }).then((res) => {
        return res.json()
    }).then((data) => {
        if(!data) {
            return;
        }
        clearAllEl(objectHolder)
        objectHolder.appendChild(createObjectEl(data));
    })
})

deleteForm.addEventListener('submit', (e) => {
    e.preventDefault();
    fetch(path + '/deleteone?id=' + deleteForm.idinput.value, {
        method: "DELETE"
    }).then(() =>{
        getallbut.click()
    })
})

insertForm.addEventListener('submit', (e) => {
    e.preventDefault();
    fetch(path + '/insertone', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: insertForm.name.value,
            email: insertForm.email.value,
            balance: parseFloat(insertForm.balance.value)
        })
    }).then(() =>{
        getallbut.click()
    })
})

updateForm.addEventListener('submit', (e) => {
    e.preventDefault()
    fetch(path + "/updateone", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: updateForm.id.value,
            name: updateForm.name.value,
            email: updateForm.email.value,
            balance: parseFloat(updateForm.balance.value),
            isActive: updateForm.isActive.value === 'true' ? true : false,
            secondsSince: parseInt(updateForm.secondsSince.value)
        })
    }).then(() => {
        updateForm.classList.add("hide")
        updateForm.style.animation = ""
        updateForm.reset()
        getallbut.click()
    })
})
