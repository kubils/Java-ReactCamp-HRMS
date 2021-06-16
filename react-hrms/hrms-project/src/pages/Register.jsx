import React from 'react'
import { Formik } from 'formik';
import * as Yup from 'yup';
import '../layouts/css/Register.css'

const validationSchema = Yup.object({
    firstName: Yup.string().required("Zorunlu alan"),
    lastName: Yup.string().required("Zorunlu alan"),
    email: Yup.string().email('Geçersiz e-mail adresi').required('Zorunlu alan'),
});

export default function AddAdvertisement() {
    return (
        <div>

            <Formik
                initialValues={{ firstName: '', lastName: '', email: '' }}
                validationSchema={validationSchema}
                onSubmit={values => {
                    console.log(values);
                }}
            >
                {({ handleSubmit, handleChange, values, errors }) => (
                    <form onSubmit={handleSubmit}>

                        <input
                            type="text"
                            name="firstName"
                            placeholder="Ad"
                            onChange={handleChange}
                            values={values.firstName}
                        />
                        {errors.firstName && errors.firstName}
                        <input
                            type="text"
                            name="lastName"
                            placeholder="Soyad"
                            onChange={handleChange}
                            values={values.lastName}
                        />
                        {errors.lastName && errors.lastName}
                        <input
                            type="text"
                            name="email"
                            placeholder="E-mail"
                            onChange={handleChange}
                            values={values.email}
                        />
                        {errors.email && errors.email}
                        <button type="submit">Kayıt Ol</button>
                    </form>
                )}
            </Formik>
        </div>
    )
}
