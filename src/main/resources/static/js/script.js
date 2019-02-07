function createPhone() {
    var phones = document.getElementsByClassName('phones');

    var lastPhone = phones[phones.length - 1];

    var new_phone = lastPhone.cloneNode(true);

    var input = new_phone.getElementsByTagName('input')[0];
    input.value = '';
    input.setAttribute('id', 'contact.phones' + phones.length + '.number');
    input.setAttribute('name', 'contact.phones[' + phones.length + '].number');

    var errorText = new_phone.getElementsByClassName('invalid-feedback')[0];

    if (errorText) {
        errorText.innerHTML = '';
    }

    document.getElementById('phones-wrapper').appendChild(new_phone);
}