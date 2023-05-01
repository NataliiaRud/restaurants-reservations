(() => {
  const refs = {
    openModalBookTableBtn: document.querySelector(
      "[data-modal-book-table-open]"
    ),
    openModalBookTableBtn2: document.querySelector(
          "[data-modal-book-table-open-2]"
    ),
    closeModalBookTableBtn: document.querySelector(
      "[data-modal-book-table-close]"
    ),
    modalBookTable: document.querySelector("[data-modal-book-table]"),
  };

  refs.openModalBookTableBtn.addEventListener("click", showModalBookTable);
  refs.openModalBookTableBtn2.addEventListener("click", showModalBookTable);
  refs.closeModalBookTableBtn.addEventListener("click", closeModalBookTable);

  function showModalBookTable() {
    refs.modalBookTable.classList.remove("is-hidden");
    window.scrollTo(0, 0);
    document.getElementById('user-name').focus();
  }

  function closeModalBookTable() {
    refs.modalBookTable.classList.add("is-hidden");
    document.getElementById('reservation-form').reset();
  }
})();
