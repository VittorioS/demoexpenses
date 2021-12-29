import React, { useEffect, useState } from "react";

import NewExpense from "src/components/NewExpense/NewExpense";
import Expenses from "src/components/Expenses/Expenses";
import { createExpenses, getExpenses, deleteExpenses } from "./utils/helper";

const DUMMY_EXPENSES = [
  {
    id: "1",
    title: "Meccanico Moto",
    amount: 250,
    date: new Date(2021, 10, 31),
  },
  { id: "2", title: "Panino", amount: 10, date: new Date(2021, 12, 7) },
  { id: "3", title: "Computer", amount: 1000, date: new Date(2021, 11, 20) },
  { id: "4", title: "Scarpe", amount: 130, date: new Date() },
];

const useFetch = (defaultValue) => {
  const [expenses, setExpenses] = useState(defaultValue);

  useEffect(() => {
    (async () => {
      try {
        setExpenses(await getExpenses());
      } catch (ex) {
        alert(ex);
      }
    })();
  }, []);

  return [expenses, setExpenses];
};

const App = () => {
  const [aExpenses, setExpenses] = useFetch(DUMMY_EXPENSES);
  const [edit, setEdit] = useState(false)

  const handleAddExpense = async (expense) => {
    try {
      const newExpense = await createExpenses(expense);
      setExpenses((prev) => [newExpense, ...prev]);
    } catch (ex) {
      alert(ex);
    }
  };

  const handleDelete = async (expense) => {
    const choose = window.confirm(
      `Sei sicuro di voler eliminare la spesa ${expense.title}?`
    );
    if (choose) {
      try {
        deleteExpenses(expense.id);
        setExpenses((prev) => prev.filter((item) => item.id !== expense.id));
      } catch (ex) {
        alert(ex);
      }
    }
  };

  const handleEdit = (value) => {
    setEdit(value)
  }
  return (
    <div>
      <NewExpense onAddExpense={handleAddExpense} onEdit={handleEdit} />
      {!edit && (
        <Expenses items={aExpenses} onDelete={handleDelete} />
      )}
    </div>
  );

  // React.createElement(
  //   "div",
  //   {},
  //   React.createElement("h2", {}, "Let's get started"),
  //   React.createElement(Expenses, {items: aExpenses})
  // );
};

export default App;
