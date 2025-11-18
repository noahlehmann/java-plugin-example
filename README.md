# Java Plugin Example

## Minimal Run Requirements

- JRE `11<x<=21`

### Optional for Development

- Maven `>3.4`
- JDK `11<x<=21`
- Docker

## Run on Docker

```bash
docker build -f Containerfile -t java-plugin-example .
docker run --name java-plugin-example --rm java-plugin-example:latest 
```