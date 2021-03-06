import React from "react";
import {useNavigate} from "react-router-dom";

const ManufacturerAdd = (props) => {
    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        address: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const address = formData.address;

        props.onAddManufacturer(name, address);
        navigate("/manufacturers");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Manufacturer name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter category name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="address">Address</label>
                        <input type="text"
                               className="form-control"
                               id="address"
                               name="address"
                               placeholder="Enter address"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default ManufacturerAdd;