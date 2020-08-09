# TDD Oriented Api Design
I find it hard to run along with Spring; because it is big and multi-layered. 
The testing libraries are just everywhere. 
Without a proper library with a correct setting, the TDD is just gone crazy. 
So I decide to create this sample to be my reference, so that I won't have any of the above difficulties anymore. 
Spring is big, and if you're not careful enough, you might end up firing a whole engine which is going to take a little bit long just to execute a test.
That's why each layer test should not invoke a whole engine to boot.

## Top Down Approach
This is one kind of TDD in which an integration test will be written first.  

## Integration Test
This is a whole test. Technically it means, an http client will send something to the api, and verify the result.
It does not care what are running behind the scene.

## Controller Test
In order not to boot up a whole Spring, a mocked service is used here.
So instead of talking with a real service, this controller test just work with the mocked service.
Doing this way, we don't care about whatever input given by a service, we just focus on processing it.

## Service Test
The Service Test is also independent from the whole tree. The idea here is to mock a repository and pass it into the service.
So that it won't depend on the real repository. 

## Repository Test
Spring provides annotation @DataJpaTest to work on a repository test. This means, the test could use the real database configuration.
And we need that, why? 
Testing it with the real database server is giving a little bit peace of mind; 
we could make sure whatever errors we might come across when deploying to production environment might also find their way into our tests as well; 
and that is a bonus for us; because we could catch the errors earlier. 
One bullet point explained by the author of the video presentation below is the benefit of using the entity manager.
This could assure that the object to verify is absolutely from the database and not from a cache.

## Reference
Thank to the great video presentation of Sannidhi Jalukar and Madhura Bhave.<br/>
[Test Driven Development with Spring Boot - Sannidhi Jalukar, Madhura Bhave](https://tanzu.vmware.com/content/springone-platform-2017/test-driven-development-with-spring-boot-sannidhi-jalukar-madhura-bhave)
