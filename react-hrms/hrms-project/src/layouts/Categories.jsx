import { result } from 'lodash'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { Dropdown, Input, Menu} from 'semantic-ui-react'
import JobTitleService from '../services/jobTitleService'

export default function Categories() {


     const [jobTitles, setJobTitles] = useState([])
    useEffect(() => {
       let jobTitle = new JobTitleService()

        jobTitle.getJobTitles().then(result => setJobTitles(result.data.data))
    }, [])


    return (
        <div>
            <Menu vertical>
                <Menu.Item>
                    <Input placeholder='Search...' />
                </Menu.Item>

                <Menu.Item

                >
                    <Link to={`/job-posts`}>  JobPosts </Link>
                    <Menu.Menu>

                        <Menu.Item
                            name='Post new advertisement'
                            as={Link} to='/add-advertisement'

                        >
                        </Menu.Item>
                        <Menu.Item
                            name='search'
                        // as={Link} to='/job-posts'
                        >
                            
                            <Dropdown  text='Job Titles'>
                                <Dropdown.Menu>
                                    
                                    {
                                        jobTitles.map(jobs =>(
                                            <option key ={jobs.id}>
                                               {jobs.title}</option>
                                               
                                        ))
                                    }
                                </Dropdown.Menu>
                            </Dropdown>
                        </Menu.Item>
                        <Menu.Item
                            name='add'

                        >
                            Search
                        </Menu.Item>

                    </Menu.Menu>
                </Menu.Item>

                <Menu.Item
                    name='browse'
                    as={Link} to='/employers'

                >
                    {/* <Icon name='grid layout' /> */}
                    Employers
                </Menu.Item>
                <Menu.Item
                    name='jobSeekers'
                    as={Link} to='/candidates'

                >
                    JobSeekers
                </Menu.Item>

                <Dropdown item text='CV'>
                    <Dropdown.Menu>
                        <Dropdown.Item icon='globe' text='Get All' as={Link} to='/resumes' />
                        <Dropdown.Item icon='edit' text='Edit Profile' />
                        <Dropdown.Item icon='settings' text='Account Settings' />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu>
        </div >
    )
}
