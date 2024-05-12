import React from "react";

const CartCard = ({ items }) => {
  return (
    <div className="cont">
      <div className="contacts ">
        <div className="contact-card"> 
          <img
            src={require("../../assets/images/cart.png").default}
            alt="1"
            height="20"
            width="20"
          />
          <h3>{items.itemName}</h3>
          <div className="info-group">
            <img src={require("../../assets/images/id.jpg").default} alt="2" />
            <p>{items.itemID}</p>
          </div>
          <div className="info-group">
            <img src={require("../../assets/images/res.png").default} alt="2" />
            <p>{items.storeName}</p>
          </div>
          <div className="info-group">
            <img
              src={require("../../assets/images/description.jpg").default}
              alt="3"
            />
            <p>{items.quantity}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartCard;
