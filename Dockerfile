FROM ubuntu:latest
LABEL authors="Dann"

ENTRYPOINT ["top", "-b"]