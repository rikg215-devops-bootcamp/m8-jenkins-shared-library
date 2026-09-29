# M8-JENKINS-SHARED-LIBRARY

## Shared library created for Jenkins

### Global Variables

- buildApp runs npm version and then builds image based on package.json version and build number jenkins variable
- buildImage builds docker image from Dockerfile and then pushes to private repository
- commitImage pushes new changes to git repository
