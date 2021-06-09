import React from 'react'
import Categories from './Categories'
import {Grid} from 'semantic-ui-react'
import EmployerUsers from '../pages/EmployerUsers';
import Resumes from '../pages/Resume';

export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <Categories />
                    </Grid.Column>
                    <Grid.Column width={12}>
                        <Resumes/>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    );
}
