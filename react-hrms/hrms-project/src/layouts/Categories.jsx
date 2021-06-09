import React from 'react'
import { Dropdown, Input, Menu } from 'semantic-ui-react'

export default function Categories() {
    return (
        <div>
            <Menu vertical>
                <Menu.Item>
                    <Input placeholder='Search...' />
                </Menu.Item>

                <Menu.Item>
                    JobPost
                <Menu.Menu>
                        <Menu.Item
                            name='search'

                        >
                            Search
                    </Menu.Item>
                        <Menu.Item
                            name='add'

                        >
                            Job Titles
                    </Menu.Item>
                        <Menu.Item
                            name='about'

                        >
                            
                    </Menu.Item>
                    </Menu.Menu>
                </Menu.Item>

                <Menu.Item
                    name='browse'

                >
                    {/* <Icon name='grid layout' /> */}
                    Employers
                    </Menu.Item>
                <Menu.Item
                    name='messages'

                >
                    JobSeekers
                    </Menu.Item>

                <Dropdown item text='CV'>
                    <Dropdown.Menu>
                        <Dropdown.Item icon='edit' text='Edit Profile' />
                        <Dropdown.Item icon='globe' text='Choose Language' />
                        <Dropdown.Item icon='settings' text='Account Settings' />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu>
        </div>
    )
}
