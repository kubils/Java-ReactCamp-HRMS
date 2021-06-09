import React, {useEffect, useState} from 'react'
import { Icon, Menu, Table } from 'semantic-ui-react'
import JobPostService from '../layouts/services/jobPostService'

export default function JobPosts() {

    //hooks
    //destructer  ;
    //setProducts -> products
    // const [products, setProducts] = useState([])
    //products.map((p) => (...
    //when products changed page render again
    const [jobPost, setjobPost] = useState([])


    //hooks
    useEffect(() =>{
        //services -> productservice
        let jobPostService = new JobPostService()
        //if success then(...) false catch(...)
        // setProducts send to products
        //axios data.(localhost)data
        jobPostService.getJobsPost().then(result => setjobPost(result.data.data))
    })

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Job</Table.HeaderCell>
                        <Table.HeaderCell>Company</Table.HeaderCell>
                        <Table.HeaderCell>Number of Position</Table.HeaderCell>
                        <Table.HeaderCell>minSalary</Table.HeaderCell>
                        <Table.HeaderCell>maxSalary</Table.HeaderCell>
                        <Table.HeaderCell>City</Table.HeaderCell>
                        <Table.HeaderCell>dateOfOpen</Table.HeaderCell>
                        <Table.HeaderCell>dateOfClosed</Table.HeaderCell>
                        {/* <Table.HeaderCell>Category</Table.HeaderCell> */}
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                       jobPost.map((j) => (
                        //unique
                        //connection with data  : swagger data
                        <Table.Row key={j.id}>
                            <Table.Cell>{j.jobDefinition}</Table.Cell>
                            <Table.Cell>{j.employers.name}</Table.Cell>
                            <Table.Cell>{j.number_of_job_position}</Table.Cell>
                            <Table.Cell>{j.minSalary}</Table.Cell>
                            <Table.Cell>{j.maxSalary}</Table.Cell>
                            <Table.Cell>{j.city.cityName}</Table.Cell>
                            <Table.Cell>{j.dateOfOpen}</Table.Cell>
                            <Table.Cell>{j.dateOfClosed}</Table.Cell>
                        </Table.Row>
                       ))
                    }

                    
                </Table.Body>

                <Table.Footer>
                    <Table.Row>
                        <Table.HeaderCell colSpan='5'>
                            <Menu floated='right' pagination>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron left' />
                                </Menu.Item>
                                <Menu.Item as='a'>1</Menu.Item>
                                <Menu.Item as='a'>2</Menu.Item>
                                <Menu.Item as='a'>3</Menu.Item>
                                <Menu.Item as='a'>4</Menu.Item>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron right' />
                                </Menu.Item>
                            </Menu>
                        </Table.HeaderCell>
                    </Table.Row>
                </Table.Footer>
            </Table>
        </div>
    )
}
