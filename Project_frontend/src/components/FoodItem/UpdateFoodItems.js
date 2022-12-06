import React, { useState } from "react";
import Container from "@material-ui/core/Container";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import RemoveIcon from "@material-ui/icons/Remove";
import AddIcon from "@material-ui/icons/Add";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { v4 as uuidv4 } from "uuid";

import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  root: {
    "& .MuiTextField-root": {
      margin: theme.spacing(1),
    },
  },
  button: {
    margin: theme.spacing(1),
  },
}));

function UpdateFootItems() {
  const classes = useStyles();
  const [inputFields, setInputFields] = useState([
    { id: uuidv4(), foodName: "Burger", foodDecription: "patty with kethup" }
    { id: uuidv4(), foodName: "Pizza", foodDecription: "cheesy" }
    { id: uuidv4(), foodName: "Zinger Burger", foodDecription: "double patty" }
    { id: uuidv4(), foodName: "Broast", foodDecription: "" }
    { id: uuidv4(), foodName: "Roll", foodDecription: "Crispy chicken" },
  ]);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("InputFields", inputFields);
  };

  const handleChangeInput = (id, event) => {
    const newInputFields = inputFields.map((i) => {
      if (id === i.id) {
        i[event.target.name] = event.target.value;
      }
      return i;
    });

    setInputFields(newInputFields);
  };

  const handleAddFields = () => {
    setInputFields([
      ...inputFields,
      { id: uuidv4(), foodName: "", foodDecription: "" },
    ]);
  };
  const notify = () => {
    toast.dark("Udpated");
  };
  const notify_decrement = () => {
    toast("Item Removed");
  };
  const handleRemoveFields = (id) => {
    const values = [...inputFields];
    values.splice(
      values.findIndex((value) => value.id === id),
      1
    );
    setInputFields(values);
  };

  return (
    <Container>
      <ToastContainer />
      <div className="text-center pt-20 mt-10">
        <h1 className="font-bold text-4xl text-blue-600 text-center ">
          Add Food Item
        </h1>

        <form className={classes.root} onSubmit={handleSubmit}>
          {inputFields.map((inputField) => (
            <div key={inputField.id}>
              <TextField
                name="foodName"
                label="Food Name"
                variant="filled"
                value={inputField.foodName}
                onChange={(event) => handleChangeInput(inputField.id, event)}
              />
              <TextField
                name="foodDescription"
                label="Food Description"
                variant="filled"
                value={inputField.foodDecription}
                onChange={(event) => handleChangeInput(inputField.id, event)}
              />
              <IconButton
                disabled={inputFields.length === 1}
                onClick={() => handleRemoveFields(inputField.id)}
              >
                <RemoveIcon />
              </IconButton>

            </div>
          ))}
          <Button
            className={classes.button}
            variant="contained"
            color="primary"
            type="submit"
            onClick={({ handleSubmit }, notify)}
          >
            Update
          </Button>
        </form>
      </div>
    </Container>
  );
}

export default AddFoodItems;
