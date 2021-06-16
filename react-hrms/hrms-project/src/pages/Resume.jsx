import React, { useEffect, useState } from 'react'
import { Icon, Image, Menu, Table, Header } from 'semantic-ui-react'
import ResumeService from '../services/resumeService'

export default function Resumes() {

    //hooks
    //destructer  ;
    //setProducts -> products
    // const [products, setProducts] = useState([])
    //products.map((p) => (...
    //when products changed page render again
    const [resumes, setResumes] = useState([[]])

    //hooks
    useEffect(() => {
        //services -> productservice
        let resumeService = new ResumeService()
        //if success then(...) false catch(...)
        // setProducts send to products
        //axios data.(localhost)data
        resumeService.getResumes().then(result => setResumes(result.data.data))
    }, [])

    // let candidateExperiences;

    // const experience = function (exp) {
    //     candidateExperiences = []
    
    //     exp.map(e => {
    //         candidateExperiences.push({key: e.id, company: e.employerName})
    //     })

    // }

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Resume Name</Table.HeaderCell>
                        <Table.HeaderCell>githubLink</Table.HeaderCell>
                        <Table.HeaderCell>linkedin</Table.HeaderCell>
                        <Table.HeaderCell>summary</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                        resumes.map((r) => (

                            //unique
                            //connection with data  : swagger data
                            <Table.Row key={r.id}>
                                <Table.Cell>{r.resumeName}</Table.Cell>
                                <Table.Cell>
                                    <Image src="https://res.cloudinary.com/pelin/image/upload/v1623170064/github_oz2p8t.png" size='mini' />
                                    {r.githubLink}</Table.Cell>
                                <Table.Cell>
                                    <Image src='https://res.cloudinary.com/pelin/image/upload/v1623170078/LinkedIn-Icon-Squircle-Dark_slfavv.png' width="15" />
                                    <Header.Content>
                                    </Header.Content>
                                    {r.linkedin}</Table.Cell>
                                <Table.Cell>{r.summary}</Table.Cell>
                                {/* <Table.Cell>{experience(r.candidateExperiences)}</Table.Cell> */}
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
