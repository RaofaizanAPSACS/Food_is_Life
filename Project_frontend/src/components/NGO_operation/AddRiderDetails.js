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
import axios from "axios";

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

function AddRiderDetails() {
  const classes = useStyles();
  const [inputFields, setInputFields] = useState([
    {
      id: uuidv4(),
      cnic: "",
      name: "",
      phone: "",
      email: "",
    },
  ]);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("InputFields", ...inputFields);

    axios
      .post("http://localhost:8086/NGO/addRiderDetails", inputFields)
      .then((result) => {
        if (result.data === "Rider Details Added") {
          alert("Rider Details Added");
          notify();
        } else {
          alert("Session Logged Out");
          window.location.href = "/LoginNGO";
        }
      })
      .catch((err) => console.log(err.response.data.message));
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
      {
        id: uuidv4(),
        cnic: "",
        name: "",
        phone: "",
        email: "",
      },
    ]);
  };
  const notify = () => {
    toast.success("Added Successfully");
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
    <Container className=" m-0">
      <ToastContainer />
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-blue-600 text-center ">
          Add Rider Details
        </h1>
        <div>
          <form className={classes.root} onSubmit={handleSubmit}>
            {inputFields.map((inputField) => (
              <div key={inputField.id}>
                <TextField
                  name="cnic"
                  label="Rider CNIC"
                  variant="filled"
                  value={inputField.cnic}
                  onChange={(event) => handleChangeInput(inputField.id, event)}
                />
                <TextField
                  name="name"
                  label="Rider Name"
                  variant="filled"
                  value={inputField.name}
                  onChange={(event) => handleChangeInput(inputField.id, event)}
                />
                <TextField
                  name="phone"
                  label="Rider Phone"
                  variant="filled"
                  value={inputField.phone}
                  onChange={(event) => handleChangeInput(inputField.id, event)}
                />
                <TextField
                  name="email"
                  label="Rider Email"
                  variant="filled"
                  value={inputField.email}
                  onChange={(event) => handleChangeInput(inputField.id, event)}
                />
                <IconButton
                  disabled={inputFields.length === 1}
                  onClick={() => handleRemoveFields(inputField.id)}
                >
                  <RemoveIcon />
                </IconButton>
                <IconButton onClick={handleAddFields}>
                  <AddIcon />
                </IconButton>
              </div>
            ))}
            <Button
              className={classes.button}
              variant="contained"
              color="primary"
              type="submit"
              onClick={handleSubmit}
            >
              Add to Menu
            </Button>
          </form>
        </div>
      </div>
    </Container>
  );
}

export default AddRiderDetails;
