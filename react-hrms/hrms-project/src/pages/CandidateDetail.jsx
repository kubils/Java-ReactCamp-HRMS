import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { Icon, Menu, Table } from 'semantic-ui-react'
import CandidateService from '../services/candidateService'
import { Button, Card } from 'semantic-ui-react'

export default function CandidateUsers() {



    let { id } = useParams()

    const [candidates, setCandidates] = useState([])




    //hooks
    useEffect(() => {
        //services -> productservice
        let candidateService = new CandidateService()
        //if success then(...) false catch(...)
        // setProducts send to products
        //axios data.(localhost)data
        candidateService.getCandidatesById(id).then(result => setCandidates(result.data.data))
    }, [])

    


    return (
        <div>
            
            <Card.Group >
                <Card fluid >
                    <Card.Content >
                        {/* {candidates.map((item)=> (
                            
                            
                            <Image
                            floated='right'
                            size='mini'
                            src="{item.cvImages((sub)=>
                                {sub.photoUrl})}" />
                       
                        ))} */}

                        <Card.Header >   {candidates.name + " " + candidates.lastName}</Card.Header>
                        <Card.Meta >{candidates.birthDate}</Card.Meta>
                        <Card.Description >
                            <Icon name='point' />
                            <strong>{candidates.email}</strong>
                        </Card.Description>

                    </Card.Content>
                    <Card.Content extra>
                        <div className='ui two buttons'>
                            <Button basic color='green'>
                                <Icon name='hand point right' />  CV
                            </Button>
                        </div>
                    </Card.Content>
                </Card>

            </Card.Group>


            <Table celled>


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
