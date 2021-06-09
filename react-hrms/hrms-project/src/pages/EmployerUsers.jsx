import React, {useEffect, useState} from 'react'
import { Icon, Menu, Table } from 'semantic-ui-react'
import EmployerService from '../layouts/services/employerService'

export default function EmployerUsers() {

    //hooks
    //destructer  ;
    //setProducts -> products
    // const [products, setProducts] = useState([])
    const [employers, setEmployers] = useState([])
    //products.map((p) => (...
    //when products changed page render again

    //hooks
    useEffect(() =>{
        //services -> productservice
        let employerService = new EmployerService()
        //if success then(...) false catch(...)
        // setProducts send to products
        //axios data.(localhost)data
        employerService.getEmployers().then(result => setEmployers(result.data.data))
    })

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Company Name</Table.HeaderCell>
                        <Table.HeaderCell>Email</Table.HeaderCell>
                        <Table.HeaderCell>Website</Table.HeaderCell>
                        <Table.HeaderCell>Phone</Table.HeaderCell>
                        {/* <Table.HeaderCell>Category</Table.HeaderCell> */}
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                       employers.map((e) => (
                        //unique
                        //connection with data  : swagger data
                        <Table.Row key={e.id}>
                            <Table.Cell>{e.name}</Table.Cell>
                            <Table.Cell>{e.email}</Table.Cell>
                            <Table.Cell>{e.website}</Table.Cell>
                            <Table.Cell>{e.phone}</Table.Cell>
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
