import React, { useState } from "react";

import "./ExpenseForm.css";

const ExpenseForm = (props) => {
  const [title, setTitle] = useState('');
  const [amount, setAmount] = useState('');
  const [date, setDate] = useState('');
  // const [form, setForm] = useState({
  //   "title": "",
  //   "amount": "",
  //   "date": new Date()
  // });
  const handleTitleChange = (oEvent) => {
    setTitle(oEvent.target.value);
    // setForm((prevState) => {
    //   return {...prevState, title: oEvent.target.value}
    // });
  };
  const handleAmountChange = (oEvent) => {
    setAmount(oEvent.target.value);
  };
  const handleDateChange = (oEvent) => {
    setDate(oEvent.target.value);
  };

  const handleSubmit = (oEvent) => {
    oEvent.preventDefault();

    const oExpenseData = {
      "title": title,
      "amount": +amount,
      "date": new Date(date)
    };
    props.onSaveExpenseData(oExpenseData);
    setTitle('');
    setAmount('');
    setDate('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="new-expense__controls">
          <div className="new-expense__control">
              <label>Titolo</label>
              <input value={title} onChange={handleTitleChange} type="text" required/>
          </div>
          <div className="new-expense__control">
              <label>Costo</label>
              <input value={amount} onChange={handleAmountChange} type="number" min="0.01" step="0.01" required/>
          </div>
          <div className="new-expense__control">
              <label>Data</label>
              <input value={date} onChange={handleDateChange} type="date" min="2019-01-01" max="2022-12-31" required/>
          </div>
      </div>
      <div className="new-expense__actions">
        <button onClick={props.onCancel}>Annulla</button>
        <button type="submit">Aggiungi Spesa</button>
      </div>
    </form>
  );
};

export default ExpenseForm;
