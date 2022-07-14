const path = '/DunderDemo'
const getallbut = document.getElementById("get-all-button")
const getoneform = document.getElementById("get-one-form")
const deleteForm = document.getElementById("delete-form")
const insertForm = document.getElementById("insert-form")
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