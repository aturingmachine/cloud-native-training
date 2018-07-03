# Questions
> At the end of this section there are some questions asked, these are my attempts to answer them.

## If the directory-service app changes its URL, what do you need to do? What about the id of the Directory, what do you need to do?

In the case of our current set up we would need to modify the `application.properties` and then rebuild the WAR as the resource file is out of reach once the application is built. This means that we should instead pull this configuration out somehow. In the case of Cloud Foundry we could set it as an Environment Variable, although I am not sure how to get to them inside a spring application (I have done so in PHP and JS before).

## How do these services communicate? Do messages go outside and return? or is this communication directly between apps?

The messages are sent completely over the web via HTTP requests, so they "go outside".

## Can we use RabbitMQ to do messaging between these two apps?

We could set up a RabbitMQ server to manage the messaging between the applications if we wished.

## How can we avoid a restage of the applications?

By making their dependent variables more dynamic. Currently the `id` of the company is hard set in the `EmployeeClient` via the `application.properties`, however that means the client can only get the employees for the first company. We could instead take in a query parameter identifying the `directory` we are attempting to access from the `DirectoryService`. This way we don't have to change the variable and restage and the application has more use cases than it currently does.

## Can we add a blue-green deployment?

I am not well versed in the methodology of BG Deployment, however I do not see why we would not be able to just spin up some more "production" level instances of these applications and begin following the BG Deployment pattern.
