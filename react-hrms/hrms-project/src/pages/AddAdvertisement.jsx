import React, { useEffect, useState } from 'react'
import { Formik } from 'formik';
import * as Yup from 'yup';
import { Card, Form, Label, Segment,Container,Button } from 'semantic-ui-react'
import jobTitleService from '../services/jobTitleService'
import cityService from '../services/cityService'
import WorkTimeService from '../services/workTimeService';
import WorkTypeService from '../services/workType.Service';
import jobPostService from '../services/jobPostService'
import employerService from '../services/employerService'


export default function AddAdvertisement() {


    const validationSchema = Yup.object({
        // employers: Yup.object({
        //     id : Yup.number().min(1)
        // }).required("asdasdasdasdasdasd"),
        // titleId: Yup.string().required(),
        // empTime: Yup.string().required(),
        // workPlace: Yup.string().required(),
        // city: Yup.number().required("city required place"),
        jobDefinition: Yup.string().required(),
        minSalary: Yup.number().min(1, 'At least 1').max(100000, 'Max amount 100000'),
        maxSalary: Yup.number().min(1, 'At least 1').max(100000, 'Max amount 100000'),
        dateOfClosed: Yup.date().required(),
        number_of_job_position : Yup.number().min(1, 'At least 1').max(100000, 'Max amount 100000')
    });

    const [jobTitles, setJobTitles] = useState([])
    const [cities, setCities] = useState([])
    const [employmentTime, setEmploymentTime] = useState([])
    const [workPlace, setEmploymentType] = useState([])
    const [employer, setEmployer] = useState([])


    

    useEffect(() => {

        let jobTitle = new jobTitleService()
        let city = new cityService()
        let employmentTime = new WorkTimeService()
        let workPlace = new WorkTypeService()
        let company = new employerService()

        jobTitle.getJobTitles().then(result => setJobTitles(result.data.data))

        city.getCities().then(result => setCities(result.data.data))

        employmentTime.getEmploymentTime().then(result => setEmploymentTime(result.data.data))

        workPlace.getWorkPlace().then(result => setEmploymentType(result.data.data))

        company.getEmployers().then(result => setEmployer(result.data.data))

    }, [])

    
    var today = new Date();
    return (

        <Container>
            <Formik 
                initialValues={{
                    employers : {
                        id : 0,
                        name : ''
                    },
                    jobTitle : {
                        id: 0,
                        title: ''
                    },
                    workTime: {
                        id: 0,
                        name: ''
                    },
                    workTypes: {
                        id: 0,
                        name: ''
                    },
                    city : {
                        cityName: '',
                        id: 0
                    },
                    jobDefinition: '',
                    minSalary: '',
                    maxSalary: '',
                    dateOfClosed: '',
                    dateOfOpen : today,
                    number_of_job_position: ''
                }}
                validationSchema={validationSchema}
                
                // onSubmit={async (values, {resetForm }) => {

                //     let jobAdvertisementService = new jobPostService();
                //     jobAdvertisementService.postDataToJobs(values).then(response =>alert(`${response.data.message}`, `${JSON.stringify(response.data)}`, "AAAAAAAAAAAAAAA"));
                    
                //     resetForm()
                //     // history.push("/job-posts");

                // }}

                onSubmit={(values, { setSubmitting, resetForm }) => {
                    // setSubmitting(true);
                    let jobAdvertisementService = new jobPostService();
                    jobAdvertisementService.postDataToJobs(values)
                    setTimeout(() => {
                      alert(JSON.stringify(values, null, 2));
                      resetForm();
                      setSubmitting(false);
                    }, 500);
                  }
                }
            >
                {({ handleSubmit, handleChange, values, errors, handleBlur, isSubmitting }) => (

                    <Card style={{
                        height: "auto",
                        width: "410px",
                        backgroundSize: "cover",
                    }}>

                        <Form onSubmit={handleSubmit}  style={{ background: "#f1f5f8"}}>
                            <Segment basic>

                            <Form.Field style={{ marginBottom: "1rem" }} >
                                <Form.Button color="yellow">
                                    <strong>ADVERTISEMENT</strong>

                                </Form.Button>

                                <Form.Field label='Company Name' control='select'
                                    onChange={handleChange}
                                    value={values.employers.id}
                                    name="employers.id"
                                    id ="emp"
                                    onBlur={handleBlur}

                                >
                                    <option value="" label="Select company">
                                        Select{" "}</option>
                                        {
                                        employer.map(e =>(
                                            <option key ={e.id} value ={e.id}>
                                               {e.name}</option>
                                        ))
                                    }
                                </Form.Field>
                                {errors.emp}

                                {/* {errors.employers &&
                                    <Label basic color='red' pointing >
                                        {errors.employers}
                                    </Label>
                                } */}

                                
                                <Form.Field label='Job Title' 
                                    control='select'
                                    onChange={handleChange}
                                    name="jobTitle.id"
                                    onBlur={handleBlur}
                                    value={values.jobTitle.id}
                                >

                                    <option value="" label="Select a title">
                                        Select{" "}
                                    </option>

                                    {
                                        jobTitles.map(jobs =>(
                                            <option key ={jobs.id} value = {jobs.id}>
                                               {jobs.title}</option>
                                        ))
                                    }
                                   
                                </Form.Field>
                                {errors.titleId &&
                                    <Label basic color='red' pointing >
                                        {errors.titleId}
                                    </Label>
                                }

                                <Form.Field label='Employment Time' control='select'
                                    name="workTime.id"
                                    onChange={handleChange}
                                    value={values.workTime.id}
                                    onBlur={handleBlur}


                                >
                                    <option value="" label="Select a title">
                                        Select{" "}</option>
                                    {
                                        employmentTime.map(e => (
                                            <option key={e.id} value ={e.id}>
                                                {e.name}</option>
                                        ))
                                    }
                                </Form.Field>
                                {errors.workTime &&
                                    <Label basic color='red' pointing >
                                        {errors.workTime}
                                    </Label>
                                }
                            </Form.Field>

                            <Form.Group grouped >
                                <Form.Field
                                    label='workTypes'
                                    control='select'
                                    name='workTypes.id'
                                    onChange={handleChange}
                                    value={values.workTypes.id}
                                    onBlur={handleBlur}

                                >
                                    <option value="" label="Select a Workplace" >
                                        Select{" "}</option>
                                    {
                                        workPlace.map(w =>(
                                            <option key ={w.id} value ={w.id} >
                                               {w.name}</option>
                                        ))
                                    }
                                </Form.Field>
                                {errors.workTypes &&
                                    <Label basic color='red' pointing >
                                        {errors.workTypes}
                                    </Label>
                                }

                                <Form.Field
                                    control='select'
                                    name='city.id'
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                    value={values.city.id}
                                    >
                                    <option value="" label="Select a city">
                                        Select a city{" "}</option>

                                    {
                                        
                                        cities.map(c => (
                                            <option type="number"
                                                key={c.id} value={c.id}>
                                                {c.cityName}</option>
                                        ))
                                    }

                                </Form.Field>
                                {/* {errors.city &&
                                    <Label basic color='red' pointing >
                                        {errors.city}
                                    </Label>
                                } */}

                                <Form.Field>
                                    <input
                                        type="number"
                                        name="minSalary"
                                        min="0"
                                        placeholder="Minimum Maaş Miktarı"
                                        onChange={handleChange}
                                        value={values.minSalary || ''}
                                        onBlur={handleBlur}

                                    />
                                    {
                                        errors.minSalary &&
                                        <Label basic color='red' pointing >
                                            {errors.minSalary}
                                        </Label>
                                    }
                                </Form.Field>

                                <Form.Field>
                                    <input
                                        type="number"
                                        name="maxSalary"
                                        min="0"
                                        placeholder="Maximum Maaş Miktarı"
                                        onChange={handleChange}
                                        value={values.maxSalary || ''}
                                        onBlur={handleBlur}


                                    />
                                    {
                                        errors.maxSalary &&
                                        <Label basic color='red' pointing >
                                            {errors.maxSalary}
                                        </Label>
                                    }
                                </Form.Field>
                                <Form.Field>
                                    <input
                                        type="number"
                                        name="number_of_job_position"
                                        min="0"
                                        placeholder="number_of_job_position"
                                        onChange={handleChange}
                                        value={values.number_of_job_position || ''}
                                        onBlur={handleBlur}

                                    />
                                    {
                                        errors.number_of_job_position &&
                                        <Label basic color='red' pointing >
                                            {errors.number_of_job_position}
                                        </Label>
                                    }
                                </Form.Field>
                                <Form.Field>
                                    <input
                                        type="date"
                                        name="dateOfClosed"
                                        placeholder="İlan Bitiş Tarihi"
                                        onChange={handleChange}
                                        value={values.dateOfClosed || ''}
                                        onBlur={handleBlur}


                                    />
                                    {
                                        errors.dateOfClosed &&
                                        <Label basic color='red' pointing >
                                            {errors.dateOfClosed}
                                        </Label>
                                    }
                                </Form.Field>
                                    <Form.Field
                                        label='Summary'
                                        control='textarea' rows='5'
                                        value={values.jobDefinition}
                                        name="jobDefinition"
                                        onChange={handleChange}
                                        onBlur={handleBlur}

                                    />
                            </Form.Group>
                            {/* <label>HTML checkboxes</label>
                                    <Form.Field label='This one' control='input' type='checkbox' />
                                    <Form.Field label='That one' control='input' type='checkbox' /> */}

                            {
                                errors.jobDefinition &&
                                <Label basic color='red' pointing >
                                    {errors.jobDefinition}
                                </Label>
                            }
                            <Form.Field control='button' type="submit">
                                     Publish 
                            </Form.Field>

                            </Segment>
                        </Form>
                    </Card>

                )}
            </Formik>
        </Container>

    )
}



