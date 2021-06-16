import React, { useEffect, useState } from 'react'
import { Icon, Menu, Table } from 'semantic-ui-react'
import CandidateService from '../services/candidateService'
import { Link } from 'react-router-dom'

export default function CandidateUsers() {



    //let { id } = useParams()
    //hooks
    //destructer  ;
    //setProducts -> products
    // const [products, setProducts] = useState([])
    const [candidates, setCandidates] = useState([])
    //products.map((p) => (...
    //when products changed page render again
    //const [cvImages] = candidates
    //hooks
    useEffect(() => {
        //services -> productservice
        let candidateService = new CandidateService()
        //if success then(...) false catch(...)
        // setProducts send to products
        //axios data.(localhost)data
        candidateService.getCandidates().then(result => setCandidates(result.data.data))
    }, [])

    return (
        <div>
           <Table celled>
                <Table.Header>
                    <Table.Row>
                        {/* <Table.HeaderCell>Image</Table.HeaderCell> */}
                        <Table.HeaderCell>Name</Table.HeaderCell>
                        <Table.HeaderCell>Last Name</Table.HeaderCell>
                        <Table.HeaderCell>Identity Number</Table.HeaderCell>
                        <Table.HeaderCell>Birth Date</Table.HeaderCell>
                        <Table.HeaderCell>Email</Table.HeaderCell>
                        {/* <Table.HeaderCell>Category</Table.HeaderCell> */}
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                        candidates.map((c) => (
                            //unique
                            //connection with data  : swagger data
                            <Table.Row key={c.id}>
                                {/* <Table.Cell>{c.cvImages.photoUrl}</Table.Cell> */}
                                <Table.Cell><Link to = {`/candidates/${c.id}`}>{c.name}</Link></Table.Cell>
                                <Table.Cell>{c.lastName}</Table.Cell>
                                <Table.Cell>{c.identityNumber}</Table.Cell>
                                <Table.Cell>{c.birthDate}</Table.Cell>
                                <Table.Cell>{c.email}</Table.Cell>
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
