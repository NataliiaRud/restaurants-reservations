const reserveAction = async () => {
  const refs = {
    modalBookTable: document.querySelector("[data-modal-book-table]"),
  };

  if (document.getElementById('user-name').value.length == 0) {
      Notiflix.Notify.warning('Будь ласка, вкажіть Ваше ім\'я');
      document.getElementById('user-name').focus();
      return;
  }

  var userNumber = document.getElementById('user-number').value;
  if (userNumber.length == 0 || !(/^[1-9]\d?$/.test(userNumber))) {
      Notiflix.Notify.warning('Будь ласка, вкажіть кількість відвідувачів');
      document.getElementById('user-number').focus();
      return;
  }

  var userPhone = document.getElementById('user-phone').value;
  if (userPhone.length == 0 || !(/^\+?\d+$/.test(userPhone))) {
      Notiflix.Notify.warning('Будь ласка, вкажіть номер телефону');
      document.getElementById('user-phone').focus();
      return;
  }

  const jsonData = {};
  jsonData["name"] = document.getElementById('user-name').value;
  jsonData["phone"] = document.getElementById('user-phone').value;
  jsonData["number"] = document.getElementById('user-number').value;
  jsonData["day"] = document.getElementById('which-day').value;
  jsonData["restaurant-id"] = document.getElementById('restaurant-id').value;

  const response = await fetch('/reserve', {
    method: 'POST',
    body: JSON.stringify(jsonData),
    headers: {
      'Content-Type': 'application/json'
    }
  }).catch(err => {
        Notiflix.Notify.failure('Помилка. Перевірте дані та спробуйте пізніше');
        return;
  });
  const responseJson = await response.json();

  if (response.ok && responseJson['status']) {
      Notiflix.Notify.success('Столик заброньовано');
      refs.modalBookTable.classList.add("is-hidden");
      document.getElementById('reservation-form').reset();
  } else {
      Notiflix.Notify.failure('Помилка. Перевірте дані та спробуйте пізніше');
  }
}

(() => {
  document.getElementById('button-send').addEventListener('click', reserveAction);
})();