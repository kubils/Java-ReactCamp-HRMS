import React from 'react'
import Categories from './Categories'
import {Grid} from 'semantic-ui-react'
import EmployerUsers from '../pages/EmployerUsers';
import CandidateUsers from '../pages/CandidateUsers';
import CandidateDetail from '../pages/CandidateDetail';
import AddAdvertisement from '../pages/AddAdvertisement';
import Register from '../pages/Register';
import { Route } from 'react-router';
import Resume from '../pages/Resume';
import JobPost from '../pages/JobPost';

export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <Categories />
                    </Grid.Column>
                    <Grid.Column width={12}>
                    <Route  exact path = "/" component = {JobPost}/>
                        <Route  exact path = "/resumes" component = {Resume}/>
                        <Route  exact path = "/job-posts" component = {JobPost}/>
                        <Route   exact path = "/candidates" component = {CandidateUsers}/>
                        <Route   exact path = "/employers" component = {EmployerUsers}/>

                        <Route   exact path = "/register" component = {Register}/>

                        <Route   path = "/candidates/:id" component = {CandidateDetail}/>
                        {/* parameter :   /products/:id */}
                        <Route   path = "/employers/:id" component = {EmployerUsers}/>
                        <Route   exact path = "/add-advertisement" component = {AddAdvertisement}/>
                    </Grid.Column>

                    
                </Grid.Row>
            </Grid>
        </div>
    );
}
