Feature: Validating Gitlab issues Api

  @Crud
  Scenario Outline: Create new issue in gitlab using API

    Given Setting up the request specification for gitlab issues api
    When  User creates new issue with "<title>" and "<description>"
    Then  Validate the <status_code> from output response
    And   Extract the response and store the issue_id

    Examples:
      | title                     | description        | status_code |
      | Issue with authentication | sample description | 201         |


  @Crud
  Scenario Outline: Reading and validating the gitlab issue output response

    Given Setting up the request specification for gitlab issues api
    When  User creates new issue with "<title>" and "<description>"
    Then  Validate the <status_code> from output response
    And   Extract the response and store the issue_id
    And   Verify the "<title>" and "<description>" in output response

    Examples:
      | title                     | description     | status_code |
      | Issue with authentication | new description | 201         |

  @Crud
  Scenario Outline: Update or edit the values using gitlab issue Api

    Given Setting up the request specification for gitlab issues api
    When  User update the existing issue "<title>" and "<description>"
    Then  Validate the <status_code> from output response
    And   Extract the response and store the issue_id
    And   Verify the "<title>" and "<description>" in output response

    Examples:
      | title        | description        | status_code |
      | UpdatedTitle | UpdatedDescription | 200         |


  @Crud
  Scenario Outline: Verify the delete functionality of gitlab issue api

    Given Setting up the request specification for gitlab issues api
    When  User deletes the existing gitlab issue
    Then  Validate the <status_code> from output response


    Examples:
      | status_code |
      | 403         |


  @EdgeCase
  Scenario Outline: Verify different edge case functionalities in Gitlab issues Api

    Given Setting up the request specification for gitlab issues api
    When  User "<resource>" an issue in Gitlab with "<new_project_id>" and "<notes>"
    Then  Validate the <status_code> from output response

    Examples:
      | status_code | resource    | new_project_id | notes |
      | 201         | unsubscribe | null           | null  |
      | 201         | subscribe   | null           | null  |
      | 400         | move        | 44118659       | null  |
      | 400         | clone       | 44118659       | true  |

#####################***************************************************************************************



#  @EdgeCase
#  Scenario Outline: Verify Unsubscribe functionality in Gitlab issues Api
#
#    Given Setting up the request specification for gitlab issues api
#    When  User unsubscribe an issue in Gitlab
#    Then  Validate the <status_code> from output response
#
#    Examples:
#      | status_code |
#      | 201         |

#
#  @EdgeCase
#  Scenario Outline: Verify Subscribe functionality in Gitlab issues Api
#
#    Given Setting up the request specification for gitlab issues api
#    When  User subscribe an issue in Gitlab
#    Then  Validate the <status_code> from output response
#
#    Examples:
#      | status_code |
#      | 201         |
#
#
#  @EdgeCase
#  Scenario Outline: Verify move an issue functionality using Gitlab Api
#
#    Given Setting up the request specification for gitlab issues api
#    When  User moves an issue to "<new_project_id>"
#    Then  Validate the <status_code> from output response
#    Examples:
#      | status_code | new_project_id |
#      | 400         | 44118659       |
#
#
#  @EdgeCase
#  Scenario Outline: Verify clone functionality in Gitlab issues Api
#
#    Given Setting up the request specification for gitlab issues api
#    When  User clone the issue with "<notes>" and "<new_project_id>"
#    Then  Validate the <status_code> from output response
#
#    Examples:
#      | status_code | new_project_id | notes |
#      | 400         | 44118659       | true  |
#









